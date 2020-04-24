<template>
  <div>
    <h1>List User</h1>
    <router-link class="btn btn-success" to="/users/create">Add User</router-link>
    <table class="table">
      <thead>
        <tr>
          <th>No</th>
          <th>Name</th>
          <th>Email</th>
          <th style="width : 220px;"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-show="!(users && users.length)">
          <td colspan="3">No Data</td>
        </tr>
        <tr v-for="(user, index) in users" :key="index">
          <td>{{index + 1}}</td>
          <td>{{user.name}}</td>
          <td>{{user.email}}</td>
          <td>
            <router-link class="btn btn-secondary" :to="`/users/${user.id}/update`">Edit User</router-link>
            <button class="btn btn-danger" @click="doDelete(user)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      users: []
    };
  },
  mounted() {
    this.loadData();
  },
  methods: {
    loadData() {
      axios
        .get("https://whereis.store/api/users")
        .then(resp => (this.users = resp.data));
    },
    doDelete(user) {
      axios
        .delete("https://whereis.store/api/users/" + user.id)
        .then(() => this.loadData());
    }
  }
};
</script>

<style>
</style>
