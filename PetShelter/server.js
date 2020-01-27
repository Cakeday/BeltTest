const express = require('express')
const app = express()
const path = require('path')

app.use(express.json())
app.use(express.static(path.join(__dirname, './client/dist/client')))

require('./server/config/modelLoader')
require('./server/config/routes')(app)

app.listen(8000)