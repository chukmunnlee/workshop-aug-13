const cliOptions = require('command-line-args')
const morgan = require('morgan')
const hbs = require('express-handlebars')
const express = require('express')

const rnd = (range = 14, total = 4) => {
	const nums = []

	for (let i = 0; i < range; i++)
		nums.push(i)

	for (let i = 0; i < range; i++) {
		const idx = Math.floor(Math.random() * range)
		const t = nums[i]
		nums[i] = nums[idx]
		nums[idx] = t
	}
	return nums.splice(0, total)
}

const instHash = (opt) => {
	if (!!opt['hash'])
		return `-${opt['hash']}`
	else if (!!process.env.INSTANCE_HASH)
		return `-${process.env.INSTANCE_HASH}`
	return ''
}

const opt = cliOptions([ 
	{ name: 'port', alias: 'p', type: Number },
	{ name: 'name', alias: 'n', type: String },
	{ name: 'hash', type: String },
])

const port = opt['port'] || opt['p'] || parseInt(process.env.PORT) || 3000
const instanceName = opt['name'] || opt['n'] || process.env.INSTANCE_NAME || ''
const instanceHash = instHash(opt)

const app = express()

app.engine('hbs', hbs({ defaultLayout: 'main.hbs' }))
app.set('view engine', 'hbs')

app.use(morgan('common'))

app.get('/healthz', (req, resp) => {
	resp.status(204).end()
})

app.use(express.static(__dirname + '/public'))

app.get([ '/', '/index.html' ], (req, resp) => {
	const total = parseInt(req.query['num']) || 4
	const dovs = rnd(14, total)
	resp.status(200).type('text/html')
	resp.render('index', { dovs, instanceName, instanceHash })
})

app.listen(port, () => {
	console.info(`Application started on port ${port} at ${new Date()}`)
})

