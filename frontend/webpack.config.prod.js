const merge = require('webpack-merge')
const ClosureCompilerPlugin = require('webpack-closure-compiler')
const webpack = require('webpack')
const common = require('./webpack.config.common')

module.exports = merge(common, {
  plugins: [
    new ClosureCompilerPlugin({
      compiler: {
        language_in: 'ECMASCRIPT6',
        language_out: 'ECMASCRIPT5'
      },
      concurrency: 3
    }),
    new webpack.EnvironmentPlugin({
      NODE_ENV: 'production'
    })
  ]
})
