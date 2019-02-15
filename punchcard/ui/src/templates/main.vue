<template>
  <span>Hello, {{ person }}!</span>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  data: {
    person: "Vue"
  }
});
</script>
