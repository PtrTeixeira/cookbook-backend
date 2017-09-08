const path = require('path')

module.exports = {
  entry: "./src/index.ts",
  output: {
    filename: "bundle.js",
    path: path.resolve(__dirname, "dist")
  },
  devtool: "source-map",
  resolve: {
    extensions: [".ts", ".tsx", ".js", ".json"]
  },
  module: {
    rules: [
      { test: /\.tsx?$/, loader: "awesome-typescript-loader", exclude: /node_modules/},
      { enforce: "pre", test: /\.js$/, loader: "source-map-loader" }
    ]
  },
  devServer: {
    contentBase: './dist',
    compress: true,
    port: 3000,
    overlay: true
  }
}
