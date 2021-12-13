const { RESTDataSource } = require("apollo-datasource-rest");

const serverConfig = require("../server");

class AccountAPI extends RESTDataSource {
  constructor() {
    super();
    this.baseURL = serverConfig.account_api_url;
  }

  async createAccount(account) {
    account = new Object(JSON.parse(JSON.stringify(account)));
    return await this.post("/account", account);
  }

  async accountByUsername(username) {
    return await this.get(`/account/${username}`);
  }

  async createConsulta(consulta) {
    consulta = new Object(JSON.parse(JSON.stringify(consulta)));
    return await this.post("/consulta", transaction);
  }

  async consultaByUsername(username) {
    return await this.get(`/consulta/${username}`);
  }
}

module.exports = AccountAPI;
