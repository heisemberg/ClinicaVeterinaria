const { gql } = require("apollo-server");

const accountTypeDefs = gql`
  type Account {
    idUsuario: String!
    firstName: String!
    lastName: String!
    correo: String!
    telefono: String!
    tipoDocumento: String!
    direccion: String!
    lastChange: String!
  }
  input CreateCustomerInput {
    idUsuario: String!
    firstName: String!
    lastName: String!
    correo: String!
    telefono: String!
    tipoDocumento: String!
    direccion: String!
    lastChange: String!
  }

  type Mutation {
    CreateCustomer(userInput: CreateCustomerInput): Account!
  }

  extend type Query {
    accountById(idUsuario: String!): Account
  }
`;

module.exports = accountTypeDefs;
