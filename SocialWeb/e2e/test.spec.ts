import { expect } from 'chai'
import { go, sleep, findId, findCSS, By } from './selenium'
describe('Test Dummy Server Example Page', () => {

    //const preamble = 'you are logged in as'

    /*before('should log in', (done) => {
        go().then(common.login).then(done)
    })*/

    it('should register a new user', (done) => {
        sleep(500)
            .then(findId('accName').sendKeys("zihan"))
            .then(done)

    })

    
})
