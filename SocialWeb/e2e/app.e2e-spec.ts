import { AppPage } from './app.po';
import { browser,by,element} from 'protractor'
//import { go, sleep, findId, findCSS, By } from './selenium'
//const webdriver = require('selenium-webdriver')

describe('social-web App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should register a new user', (done) => {

      browser.get('/landing')
      let accName=element(by.id('accName'));
      accName.sendKeys("zihan");
      let disName=element(by.id('disName'));
      disName.sendKeys("zihan");
      let email=element(by.id('email'));
      email.sendKeys("zl58@rice.edu");
      let phone=element(by.id('phone'));
      phone.sendKeys("111-222-1212");
      let pw=element(by.id('password1'));
      pw.sendKeys("123");
      let birth=element(by.id('birth'));
      birth.sendKeys("09-09-1998");
      let cpw=element(by.id('cpw'));
      cpw.sendKeys("123");
      let zip=element(by.id('zip'));
      zip.sendKeys("77005");
      let register=element(by.id('register'));
      register.click();
      browser.sleep(500);
      expect(element(by.id('message')).getText()).toEqual("you have registered successfully").then(done)
  })
  it('should log in as your test user', (done) => {

      let name=element(by.id('name'));
      name.sendKeys("zl58");
      let pw=element(by.id('password'));
      pw.sendKeys("123-123-1234");
      let login=element(by.id('login'));
      login.click();
      browser.sleep(500);
      expect(element(by.id('authorName')).getText()).toEqual("Zihan Li").then(done)
  })
  it('should create a new article and validate the article appears in the feed', (done) => {

      let article=element(by.id('myArticle'));
      article.sendKeys("test article");

      let post=element(by.id('post'));
      //let count=element.all(by.id('articles')).count();
      post.click();

      browser.sleep(500);
      //let count1=element.all(by.id('articles')).count();
      expect(element.all(by.css('p.articleText')).first().getText()).toEqual("test article").then(done)
  })
  it('should edit an article and validate the article text has updated', (done) => {

      let edit=element(by.id('edit_2976346'));
      let text = element(by.id('articleText2976346'));
      edit.click();
      browser.sleep(500);
      let area=element(by.id('editArticle2976346'));
      let save=element(by.id('saveArticle2976346'));
      expect(area.isDisplayed()).toEqual(true)
      area.clear();
      area.sendKeys("abcd article");
      save.click();
      browser.sleep(500);
      expect(area.isDisplayed()).toEqual(false)
      expect(text.getText()).toEqual("abcd article").then(done)
  })
  it('should update the status headline and verify the change', (done) => {

    let newStatus=element(by.id('newStatus'));
    newStatus.clear();
    newStatus.sendKeys("this is new status");
    let updateStatus=element(by.id('updateStatus'));
    updateStatus.click();
    let status=element(by.id("status"));
    expect(status.getText()).toEqual("this is new status").then(done);
  })
  it('should count the number of followed users', (done) => {

    let follows=element.all(by.css('p.followNames'));
    expect(follows.count()).toEqual(3).then(done);
  })
  it('should add the user "Follower" to the list of followed users and verify the count increases by one', (done) => {

    let newFollow=element.all(by.id('newFollow'));
    newFollow.sendKeys("Follower");
    let addFollow=element(by.id('addFollow'));
    addFollow.click();
    let follows=element.all(by.css('p.followNames'));
    expect(follows.count()).toEqual(4).then(done);
  })
  it('should remove the user "Follower" from the list of followed users and verify the count decreases by one', (done) => {

    let unfollow=element.all(by.id('unfollowFollower'));
    unfollow.click();
    let follows=element.all(by.css('p.followNames'));
    expect(follows.count()).toEqual(3).then(done);
  })
  it('should search for Only One Article Like This and verify only one article shows, and verify the author', (done) => {

    let searchKey=element.all(by.id('searchKeyword'));
    searchKey.sendKeys("laoreet.");
    browser.sleep(500);
    let articles=element.all(by.id('articles'));
    expect(articles.count()).toEqual(1).then(done);
  })
  it('should navigate to the profile view, Update the users email and verify', (done) => {

    let toProfile=element.all(by.id('toProfile'));
    toProfile.click();
    browser.sleep(500);
    let editEmail=element.all(by.id('editEmail'));
    editEmail.sendKeys("abc@r.com");
    let updateInfo=element(by.id("updateInfo"));
    updateInfo.click();
    let email=element(by.id("email"));
    expect(email.getText()).toEqual("email adress: abc@r.com").then(done);
  })
  it('should navigate to the profile view, Update the users zipcode and verify', (done) => {

    let editZipcode=element.all(by.id('editZipcode'));
    editZipcode.sendKeys("12345");
    let updateInfo=element(by.id("updateInfo"));
    updateInfo.click();
    let zipcode=element(by.id("zipcode"));
    expect(zipcode.getText()).toEqual("zipcode: 12345").then(done);
  })
  it('should navigate to the profile view, Update the users password, verify a "will not change" message is returned', (done) => {

    let editPassword=element.all(by.id('editPassword'));
    editPassword.sendKeys("123");
    let updateInfo=element(by.id("updateInfo"));
    updateInfo.click();
    let message=element(by.id("pwErr"));
    expect(message.getText()).toEqual("password will not change").then(done);
  })





});
