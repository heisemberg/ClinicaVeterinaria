const transactionResolver = {
  Query: {
    consultaByUsername: async (
      _,
      { username },
      { dataSources, userIdToken }
    ) => {
      usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username;
      if (username == usernameToken)
        return dataSources.accountAPI.transactionByUsername(username);
      else return null;
    },
  },
  Mutation: {
    createConsulta: async (_, { consulta }, { dataSources, userIdToken }) => {
      usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username;
      if (consulta.usernameOrigin == usernameToken)
        return dataSources.accountAPI.createTransaction(consulta);
      else return null;
    },
  },
};

module.exports = transactionResolver;
