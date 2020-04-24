<template>
  <div>
    <h1>Create User</h1>
    <div class="row">
      <div class="col-md-12">
        <label>Name</label>
        <input type="text" class="form-control" v-model="user.name"/>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <label>Email</label>
        <input type="text" class="form-control" v-model="user.email"/>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <button class="btn btn-success" @click="doSave()">Save</button>
        <button class="btn btn-secondary" onclick="history.back()">Cancel</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      user: {}
    };
  },
  methods: {
    doSave() {
      axios
        .post("http://178.128.219.218:3002/users", this.user)
        .then(() => this.$router.push('/'));
    }
  }
};
</script>

<style>
</style>
