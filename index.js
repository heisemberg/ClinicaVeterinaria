import express from "express";
import constants from "./constants";
import pkg from "./package.json";
const app = express();

app.get("/", (req, res) => {
  res.json({
    author: pkg.author,
    description: pkg.description,
    version: pkg.version,
  });
});

app.listen(constants.port, () => {
  console.log(`Listening on port ${constants.port}`);
});
