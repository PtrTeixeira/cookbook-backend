const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
  entry: './src/index.ts',
  resolve: {
    extensions: ['.ts', '.js', '.json']
  },
  module: {
    rules: [
      {test: /\.tsx?$/, loader: 'awesome-typescript-loader'},
      {enforce: 'pre', test: /\.js$/, loader: 'source-map-loader'},
      {test: /\.css$/, use: ['style-loader', 'css-loader']}
    ]
  },
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  },
  plugins: [
    new HtmlWebpackPlugin({
      title: 'Klaatu Cookbook',
      googleClientId: '239489044802-bfh4cug0qg5qb6p4i64ml3alp4mq4g24.apps.googleusercontent.com',
      template: './src/index.html'
    })
  ]
}
