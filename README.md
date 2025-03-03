# mbl-system-portal-regression
## Description

This project is designed for regression testing of the MBL System Portal. 
Used Maven as build and configuration management.
Used TestNG for test management.
POM architecture followed for organizing web elements and tests

## Project Structure

### 
```
mbl-system-portal-regression/
├── bin
|   ├── DataFiles
|   |   ├──users.xlsx
|   ├── resources
|       ├── testng.xml
├── src/
│   ├── main/
│   │   ├── java/com/konasl/mbl
│   │       |__ system/admin/pages
|   |       |      |__ PAGE OBJECTs
|   |       |__ utils
|   |              |__ UTILITY files
|   |
│   └── test/
│       ├── java/com/konasl/mbl/system/mblAdmin
|                   |__ TEST FILES
├── .gitignore
├── README.md
└── pom.xml
```

## TestNG Configuration

The `testng.xml` file used for configuring the test suite is as follows:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

<suite name="MBL Rainbow | MBL Rainbow Web Test Suite" thread-count="1" parallel="tests" verbose="1">

    <test name=" Admin Dashboard Test - chrome" parallel="methods" thread-count="1">
        <parameter name="browser" value="chrome" />
        <!--groups>
            <run>
                <include name="regression"/>
            </run>
        </groups-->

        <classes>
            <class name="com.konasl.mbl.system.mblAdmin.NotificationManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.AdminDashboard"></class>
            <class name="com.konasl.mbl.system.mblAdmin.LocationManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.BranchManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.MerchantManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.NotificationManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.LocationManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.LoginTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.ApprovalManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.BranchManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.UserManagementTest"></class>
            <class name="com.konasl.mbl.system.mblAdmin.BillPayManagementTest"></class>
        </classes>
    </test>

</suite>
```



