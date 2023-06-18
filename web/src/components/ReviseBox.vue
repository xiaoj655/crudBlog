<script setup>
  import { ref } from 'vue'
  const textarea = ref('')
</script>

<script>
export default {
  props: ['modelValue'],
  emits: ['update:modelValue','close','update'],
}
</script>

<template>
<div class="mask"></div>
<div class="wrapper">
    <textarea name="article" id="" cols="60" rows="30" class="editContent"
    :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
    ></textarea>
    <el-button type="success" circle style="height: 40px; width: 40px;" size="large" class="btn"
    @click="$emit('update')"
    >
        <el-icon><Check /></el-icon>
    </el-button>
    <el-button type="danger" circle style="height: 40px; width: 40px;" size="large" @click="$emit('close')">
        <el-icon><Delete /></el-icon>
    </el-button>
</div>
</template>

<style lang="scss" scoped>
.wrapper {
    position: fixed;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    z-index: 2;
    .article {
        border: none;
        padding: none;
        width: 300px;
        height: 300px;
        opacity: 0.5;
        background: blue;
    }
}
.mask {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1;
}
.btn {
    margin:0 30px 0 260px;
}
.editContent {
    font-size: 18px;
}
textarea {
  font-family: Arial, sans-serif;
  font-size: 16px;
  color: #333;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 5px;
  border-style: none;
  background-color: #f7f7f7;
  outline: none;
}
</style>