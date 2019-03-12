const proxy = require('http-proxy-middleware')

module.exports = function(app) {
	app.use(proxy('/api', {
		logLevel: 'debug',
		pathRewrite: {
			'^/api': ''
		},
		target: 'http://localhost:8080'
	}))
}

