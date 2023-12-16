/*
환경 세팅 시 nvm 이용해 node, npm 최신 버전으로 업그레이드 후 진행해야 됨
fastify : https://fastify.dev/docs/latest/Guides/Getting-Started/#install
 */

// Require the framework and instantiate it
const fastify = require('fastify')({
    logger: true
})

// Declare a route
fastify.get('/', function (request, reply) {
    reply.send({ hello: 'world' })
})

// Run the server!
fastify.listen(3000, '0.0.0.0', function (err, address) {
    if (err) {
        fastify.log.error(err)
        process.exit(1)
    }
    fastify.log.info(`server listening on ${address}`)
})