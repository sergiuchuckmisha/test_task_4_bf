# test_task_4_bf
test_task_4_bf

Purpose of this project is to cover https://exonum.com/demo/voting/#/welcome with autotests

 - Prerequisites:
  - Java 8
  - Maven 3.2.5+
  - last Chrome (version 64)
  - last chromedriver (version 2.35) can be downloaded at https://chromedriver.storage.googleapis.com/index.html?path=2.35/
   - driver should be placed in folder 'C:\dev\programs\drivers\chromedriver.exe' (this path is hardcoded in config.Config.DRIVER_CHROME_PATH) or this path can be customized in case of another OS
  - instruction for chrome driver installation: https://sites.google.com/a/chromium.org/chromedriver/getting-started
 - How to run:
  - mvn clean install
  - run tests manually from IDE

  * need to note that I was not able to config webdriver to get stable results. Sometimes tests are fail without any obvious reason.
  However, if run tests in iterations: run all tests, then rerun all failed, then again rerun all failed - Usually it take me 3 iterations to run all tests successfully.

  Few notes about testing framework: it contains 3 logical layers: pageObjects, actions and tests.
  Theoretically, pageObjects deal with locators and primitive types (String, boolean),
  actions deal with complex types (business logic entities) (like CryptoDetails which are received in email)
  tests are series of actions.
  In this particular case often there is no reason between pageObjects functionality and actions functionality (because business logic entities are represented with primitive types)
  and because of this I often use same interfaces both for pageObjects and for actions.
  Also, I tried to use interfaces as much as possible.

  to work with email I used code from https://github.com/redcodeg/JGuerrillaMail


found issues:
 - monitor page is unfinished:
  - several checkboxes can be selected at monitor page(shouldn't only one be selectable?)
  - no further actions are possible at monitor page
 - help link (top menu) does not work
 - settings (bottom menu) does not work
 - 2 fake candidates are present (for US election)
 - when voting for US president in confirmation popup link to Estionian site (http://www.vvk.ee/?lang=en) is present
 - when signing ballot some PIN2 code is asked. What is it? What is PIN1 code?
  - this PIN code is not required and is not validated (can sign without and with partially entered PIN code)
 - 'SAVE BALLOT DETAILS' button on page 'Your Decrypted Ballot' does nothing
 - on page https://exonum.com/demo/voting/#/elections/hash BIP 0039 verification instructions are announced, but absent