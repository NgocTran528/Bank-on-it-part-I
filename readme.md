```mermaid
classDiagram
direction TB
    class HasMenu {
        <<interface>>
        + String menu()
        + void start()
    }
    
    class CheckingAccount {
        # double balance
        + CheckingAccount()
        + CheckingAccount(double balance)
        + main()
        + String menu()
        + void start()
        + double getBalance()
        + String getBalanceString()
        + void setBalance(double balance)
        + void checkBalance()
        - double getDouble()
        + void makeDeposit()
        + void makeWithdrawal()
    }
    
    class SavingsAccount {
        # double interestRate
        + main()
        + void calcInterest()
        + void setInterestRate(double rate)
        + double getInterestRate()
    }

    class User {
        <<abstract>>
        # String userName
        # String PIN
        + boolean login()
        + boolean login(String userName, String PIN)
        + void setUserName(String userName)
        + String getUserName()
        + void setPIN(String PIN)
        + String getPIN()
        + String getReport()*
    }

    class Customer {
        # CheckingAccount checking
        # SavingsAccount savings
        + main()
        + Customer()
        + Customer(String userName, String PIN)
        + String menu()
        + void start()
        + void changePIN()
        + String getReport()
    }
    
    HasMenu <|.. CheckingAccount
    HasMenu <|.. User
    CheckingAccount <|-- SavingAccount
    User <|-- Customer

## Algorithm

### CheckingAccount::start
```
    keepGoing = true
    while keepGoing
        choice = menu()
        if "1" call checkBalance
        if "2" call makeDeposit
        if "3" call makeWithdrawal
        if "0" set keepGoing to false
```

### CheckingAccount::getBalanceString
```
    return balance formatted with a dollar sign and 2 decimal places
```

### CheckingAccount::getDouble
```
    try
        read a line and convert it to a double
    catch an exception
        print a message and use 0
    return the double
```

### CheckingAccount::makeDeposit
```
    ask how much
    amount = getDouble()
    add amount to balance
    print the new balance
```

### CheckingAccount::makeWithdrawal
```
    interest = balance * interestRate
    add interest to balance
```

### User::login()
```
    ask for user name and PIN
    return login(name, pin)
```

### User::login(user, PIN)
```
    if both match this user's name and PIN
        print "Login Successful" and return true
    else
        print "Login Failed" and return false
```

### Customer::start
```
    keepGoing = true
    while keepGoing
        choice = menu()
        if "1" print "Checking Account" and call checking.start()
        if "2" print "Savings Account" and call savings.start()
        if "3" call changePIN
        if "0" set keepGoing to false
```

### Custoemr::changePIN
```
    ask for a new PIN
    call setPIN with it
```

### Customer::getReport
```
    build a string with the user name, checking balance, savings balance
    return it
```






