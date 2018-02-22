# test_task_4_bf
test_task_4_bf

Purpose of this project is to cover https://exonum.com/demo/voting/#/welcome with autotests

 - Prerequisites:
  - Java 8
  - Maven 3.2.5+
  - last Chrome (version 64)
  - last chromedriver (version 2.35) can be downloaded at https://chromedriver.storage.googleapis.com/index.html?path=2.35/
   - driver should be placed in folder 'C:\dev\programs\drivers\chromedriver.exe' (this path is hardcoded in config/Config.java:31) or this path can be customized in case of another OS
  - instruction for chrome driver installation: https://sites.google.com/a/chromium.org/chromedriver/getting-started
 - How to run:
  - mvn clean install
  - run tests manually from IDE


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