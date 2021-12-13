//Se llama al typedef (esquema) de cada submodulo
const accountTypeDefs = require("./account_type_defs");
const consultaTypeDefs = require("./consulta_type_defs");
const authTypeDefs = require("./auth_type_defs");

//Se unen
const schemasArrays = [authTypeDefs, accountTypeDefs, consultaTypeDefs];

//Se exportan
module.exports = schemasArrays;
