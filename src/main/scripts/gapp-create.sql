

 create table academicrecords (
        academicRecordId  serial not null,
        gpa float4 not null,
        greScore int4 not null,
        toeflScore int4 not null,
        transcript varchar(255),
        applications_applicationId int4,
        user_userId int4,
        primary key (academicRecordId)
    );

    

    create table additionaldocs (
        docId  serial not null,
        docName varchar(255),
        docType varchar(255),
        required boolean not null,
        dept_deptId int4,
        primary key (docId)
    );

    create table additionaldocsvalues (
        additionalDocsValuesId  serial not null,
        additionalDocValue varchar(255),
        additionalDoc_docId int4,
        application_applicationId int4,
        primary key (additionalDocsValuesId)
    );

    create table applications (
        applicationId  serial not null,
        dateSubmitted timestamp,
        academicRecords_academicRecordId int4,
        dept_deptId int4,
        program_programId int4,
        studentInfo_studentInfoId int4,
        term_termId int4,
        user_userId int4,
        primary key (applicationId)
    );

    create table applicationstatus (
        applicationStatusId  serial not null,
        status varchar(255),
        primary key (applicationStatusId)
    );

    create table applicationstatuschange (
        applicationStatusChangeId  serial not null,
        changedTime timestamp,
        comment varchar(255),
        application_applicationId int4,
        applicationstatus_applicationStatusId int4,
        primary key (applicationStatusChangeId)
    );

    create table departments (
        deptId  serial not null,
        deptName varchar(255),
        primary key (deptId)
    );

    create table educationalbackground (
        educationalBackgroundId  serial not null,
        degree varchar(255),
        degreeEnd varchar(255),
        degreeStart varchar(255),
        major varchar(255),
        university varchar(255),
        applications_applicationId int4,
        user_userId int4,
        primary key (educationalBackgroundId)
    );

    create table programs (
        programId  serial not null,
        programName varchar(255),
        dept_deptId int4,
        primary key (programId)
    );

    create table studentinfo (
        studentInfoId  serial not null,
        cin varchar(255),
        citizenship varchar(255),
        contact varchar(255),
        dob varchar(255),
        email varchar(255),
        firstName varchar(255),
        gender varchar(255),
        lastName varchar(255),
        applications_applicationId int4,
        user_userId int4,
        primary key (studentInfoId)
    );

    create table terms (
        termId  serial not null,
        term varchar(255),
        year int4,
        primary key (termId)
    );

    create table users (
        userId  serial not null,
        email varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        password varchar(255),
        userType_userTypeId int4,
        primary key (userId)
    );

    create table users_academicrecords (
        User_userId int4 not null,
        academicRecords_academicRecordId int4 not null
    );

    create table users_educationalbackground (
        User_userId int4 not null,
        educationbackgrounds_educationalBackgroundId int4 not null
    );

    create table users_studentinfo (
        User_userId int4 not null,
        studentInfo_studentInfoId int4 not null
    );

    create table usertypes (
        userTypeId  serial not null,
        userTypeName varchar(255),
        primary key (userTypeId)
    );

    alter table users_academicrecords 
        add constraint UK_ltvstbdtkliyfbly90nb80b0q unique (academicRecords_academicRecordId);

    alter table users_educationalbackground 
        add constraint UK_8iv3jyksjkmiowyke5upo2htr unique (educationbackgrounds_educationalBackgroundId);

    alter table users_studentinfo 
        add constraint UK_r8013xtfbidseudarfcknru4i unique (studentInfo_studentInfoId);

    alter table academicrecords 
        add constraint FKa4h1joxgks2a86rnl14b0bcm2 
        foreign key (applications_applicationId) 
        references applications;

    alter table academicrecords 
        add constraint FK6c1nuhbkun62vd15hkwafvsn6 
        foreign key (user_userId) 
        references users;

    alter table additionaldocs 
        add constraint FKtn5sv2ho41avfh249ig3vqwbh 
        foreign key (dept_deptId) 
        references departments;

    alter table additionaldocsvalues 
        add constraint FK1lxsma2ack878s84f9lu76i0x 
        foreign key (additionalDoc_docId) 
        references additionaldocs;

    alter table additionaldocsvalues 
        add constraint FKrdvu9654et6ncw7sgwh08fpbg 
        foreign key (application_applicationId) 
        references applications;

    alter table applications 
        add constraint FKthvadxx1910t8gl9wlxte83ys 
        foreign key (academicRecords_academicRecordId) 
        references academicrecords;

    alter table applications 
        add constraint FKg4j5f769olw9g9wnar87dy6h7 
        foreign key (dept_deptId) 
        references departments;

    alter table applications 
        add constraint FK87ov2rf2hhktlco4hq15y9wru 
        foreign key (program_programId) 
        references programs;

    alter table applications 
        add constraint FKny3apj44l25expyt1q3fishhx 
        foreign key (studentInfo_studentInfoId) 
        references studentinfo;

    alter table applications 
        add constraint FKp1y80k7kjair0xpjf0h4272yc 
        foreign key (term_termId) 
        references terms;

    alter table applications 
        add constraint FK7n7lfjys2rcewxphnqlggbi2p 
        foreign key (user_userId) 
        references users;

    alter table applicationstatuschange 
        add constraint FKc62fnjtoln3ixsjyqcwdka7ct 
        foreign key (application_applicationId) 
        references applications;

    alter table applicationstatuschange 
        add constraint FK27wc27949e11ehdawgm89h045 
        foreign key (applicationstatus_applicationStatusId) 
        references applicationstatus;

    alter table educationalbackground 
        add constraint FKkfjcxkmhnwac7va5h13ntpwyr 
        foreign key (applications_applicationId) 
        references applications;

    alter table educationalbackground 
        add constraint FKo0sqvm01l18v7famls7yg45ud 
        foreign key (user_userId) 
        references users;

    alter table programs 
        add constraint FKd59iv01114xauqddoa82qgs5o 
        foreign key (dept_deptId) 
        references departments;

    alter table studentinfo 
        add constraint FKr8gbigwkl5nftbtt72y4c218w 
        foreign key (applications_applicationId) 
        references applications;

    alter table studentinfo 
        add constraint FKs4etfxvfcjunximk6d03qt8xr 
        foreign key (user_userId) 
        references users;

    alter table users 
        add constraint FKjx22mrvhhx3qmwbu3rlh805rl 
        foreign key (userType_userTypeId) 
        references usertypes;

    alter table users_academicrecords 
        add constraint FK8bcxjlq69c25h9x04uyho56j 
        foreign key (academicRecords_academicRecordId) 
        references academicrecords;

    alter table users_academicrecords 
        add constraint FKk9wm54p7rba3pyo74i6x4cnj5 
        foreign key (User_userId) 
        references users;

    alter table users_educationalbackground 
        add constraint FKh2yko3pud46f63ia2wputs25t 
        foreign key (educationbackgrounds_educationalBackgroundId) 
        references educationalbackground;

    alter table users_educationalbackground 
        add constraint FKtc2vb70or2f1tua68p49ad4d8 
        foreign key (User_userId) 
        references users;

    alter table users_studentinfo 
        add constraint FKgd70v4707o56it6oehym7f5j3 
        foreign key (studentInfo_studentInfoId) 
        references studentinfo;

    alter table users_studentinfo 
        add constraint FKigh3d7ptf996p68gk6fjcscch 
        foreign key (User_userId) 
        references users;

        
        insert into applicationstatus (status) values('New');
insert into applicationstatus  (status) values('Pending Review');
insert into applicationstatus (status) values('Denied');
insert into applicationstatus (status) values('Recommend Admit');
insert into applicationstatus (status) values('Recommend Admit w/ Condition');
insert into applicationstatus (status) values('Not Submitted');
insert into applicationstatus (status) values('Incomplete');
select * from applicationstatus;


insert into terms (term,year)values('Fall',2016);
insert into terms (term,year) values('Spring',2017);
insert into terms (term,year) values('Fall',2017);
select * from terms;



insert into departments (deptname) values('Accounting');
insert into departments (deptname) values('Computer Science');
select * from departments;


insert into usertypes (usertypename) values('Administrator');
insert into usertypes (usertypename) values('university Staff');
insert into usertypes (usertypename) values('Department Staff');
insert into usertypes (usertypename) values('Admission Committee Staff');
insert into usertypes (usertypename) values('Student');
insert into usertypes (usertypename) values('Saved');
select * from usertypes;


insert into programs (programname,dept_deptid) values('MS in Accounting',1);
insert into programs (programname,dept_deptid) values('MS in Computer Science',2);
select * from programs;


insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Admin','User','admin@localhost.localdomain','abcd',1);
insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Staff1','univ','staff1@localhost.localdomain','abcd',2);
insert into users (firstName,lastName,email,password,userType_userTypeId)values
('Staff2','dept','staff2@localhost.localdomain','abcd',3);
insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Student1','Stu','student1 @localhost.localdomain','abcd',5);
insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Student2','Stu','student2 @localhost.localdomain','abcd',5);
select * from users;


insert into additionaldocs (docname,doctype,required,dept_deptid) values('GMAT','number','t',1);
select * from additionaldocs;


insert into academicrecords (toeflscore,grescore,gpa,transcript,user_userid) values(92,302,3.5,'transcript.pdf',4);
select * from academicrecords;


insert into educationalbackground (degree,degreeend,degreestart,major,university,user_userid) values('Bachelor of Technology','05/09/2014','08/09/2010','Information Technology','Anna
University',4);
select * from educationalbackground;


insert into studentinfo (cin,citizenship,contact,dob,email,firstname,gender,lastname,user_userid) values('304988689','India','2135317829','07/01/1993','student1@localhost.localdomain','Student1','Female','Stu',4);
select * from studentinfo;

insert into applications (datesubmitted,academicrecords_academicrecordid,dept_deptid,program_programid,studentinfo_studentinfoid,term_termid,user_userid) values('02/22/2016',1,1,1,1,1,4);
select * from applications;

insert into applicationstatuschange (changedtime,comment,application_applicationid,applicationstatus_applicationstatusid) values(now(),'Status has been changed. Please wait for further updates',1,1);
select * from applicationstatuschange;

insert into additionaldocsvalues (additionaldocvalue,additionaldoc_docid,application_applicationid) values('700',1,1);
select * from additionaldocsvalues;



select * from academicrecords;


update academicrecords   SET applications_applicationid   = 1 where academicrecordid=1;
update educationalbackground  set applications_applicationid  =1 where educationalbackgroundid=1;
update studentinfo set applications_applicationid  =1 where studentinfoid=1;


insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Admin','User','a','a',1);
insert into users (firstName,lastName,email,password,userType_userTypeId) values
('Student2','Stu','s','s',5);
