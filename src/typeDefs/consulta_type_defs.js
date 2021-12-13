const { gql } = require("apollo-server");

const consultaTypeDefs = gql`
  type Consulta {
    idConsulta: String!
    nombreMascota: String!
    especie: String!
    raza: String!
    motivoConsulta: String!
    edad: Int!
    enfermedadesAnteriores: String!
    cirugias: String!
    date: String!
  }

  input ConsultaInput {
    nombreMascota: String!
    especie: String!
    raza: String!
    motivoConsulta: String!
    edad: Int!
    enfermedadesAnteriores: String!
    cirugias: String!
    date: String!
  }

  extend type Query {
    consultaByUsername(nombreMascota: String!): [Consulta]
  }

  extend type Mutation {
    createConsulta(consulta: ConsultaInput!): Consulta
  }
`;

module.exports = consultaTypeDefs;
