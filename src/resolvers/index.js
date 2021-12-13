const accountResolver = require("./account_resolver");
const consultaResolver = require("./consulta_resolver");
const authResolver = require("./auth_resolver");

const lodash = require("lodash");

const resolvers = lodash.merge(accountResolver, consultaResolver, authResolver);

module.exports = resolvers;
