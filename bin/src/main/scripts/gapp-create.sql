create table academicrecords (
        academicRecordId  serial not null,
        gpa float4 not null,
        greScore int4 not null,
        toeflScore int4 not null,
        transcipt bytea,
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
        academicRecords_academicRecordId int4,
        dept_deptId int4,
        educationalBackground_educationalBackgroundId int4,
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
        applicationstatuschange varchar(255),
        changeTime timestamp,
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
        degreeEnd timestamp,
        degreeStart timestamp,
        major varchar(255),
        university varchar(255),
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
        dob timestamp,
        email varchar(255),
        firstName varchar(255),
        gender varchar(255),
        lastName varchar(255),
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
        staffDept_deptId int4,
        userType_userTypeId int4,
        primary key (userId)
    );

    create table usertypes (
        userTypeId  serial not null,
        userTypeName varchar(255),
        primary key (userTypeId)
    );

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
        add constraint FKo8qf3t4bd4odkw8003g1j61w2 
        foreign key (educationalBackground_educationalBackgroundId) 
        references educationalbackground;

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

    alter table programs 
        add constraint FKd59iv01114xauqddoa82qgs5o 
        foreign key (dept_deptId) 
        references departments;

    alter table users 
        add constraint FKlpi34o5cmw4jyap2g7ajui0g4 
        foreign key (staffDept_deptId) 
        references departments;

    alter table users 
        add constraint FKjx22mrvhhx3qmwbu3rlh805rl 
        foreign key (userType_userTypeId) 
        references usertypes;


insert into applicationstatus values(1,'New');
insert into applicationstatus values(2,'Pending Review');
insert into applicationstatus values(3,'Denied');
insert into applicationstatus values(4,'Recommend Admit');
insert into applicationstatus values(5,'Recommend Admit w/ Condition');

insert into terms values(1,'Fall',2016);
insert into terms values(2,'Spring',2017);
insert into terms values(3,'Fall',2017);

insert into departments values(1,'Accounting');
insert into departments values(2,'Computer Science');

insert into usertypes values(1,'Administrator');
insert into usertypes values(2,'university Staff');
insert into usertypes values(3,'Department Staff');
insert into usertypes values(4,'Admission Committee Staff');
insert into usertypes values(5,'Student');

insert into programs values(1,'MS in Accounting',1);
insert into programs values(2,'MS in Computer Science',2);



insert into users (firstName,lastName,email,password,userType_userTypeId) values('Admin','User','admin@localhost.localdomain','abcd',1);
insert into users (firstName,lastName,email,password,userType_userTypeId) values('Staff1','univ','staff1@localhost.localdomain','abcd',2);
insert into users (firstName,lastName,email,password,userType_userTypeId,staffDept_deptId)values('Staff2','dept','staff2@localhost.localdomain','abcd',3,2);
insert into users (firstName,lastName,email,password,userType_userTypeId) values('Student1','Stu','student1 @localhost.localdomain','abcd',5);
insert into users (firstName,lastName,email,password,userType_userTypeId) values('Student2','Stu','student2 @localhost.localdomain','abcd',5);

insert into additionaldocs values(1,'GMAT','number','t',1);

insert into academicrecords values(1,92,302,3.5,'transcript.pdf');

insert into educationalbackground (university,degree,degreeStart,degreeEnd,major)values('Anna University','Bachelor of Technology','08/09/2010','05/09/2014','Information Technology');

insert into studentinfo (firstName,lastName,email,cin,contact,gender,dob,citizenship) values('Student1','Stu','student1@localhost.localdomain','304988689','2135317829','Female','07/01/1993','India');

insert into applications (academicRecords_academicRecordId,dept_deptId,educationalBackground_educationalBackgroundId,program_programId,studentInfo_studentInfoId,term_termId,user_userId)  values(1,1,1,1,1,1,4);

insert into applicationstatuschange (comment,applicationstatus_applicationStatusId,application_applicationId,changeTime) values('Status has been changed. Please wait for further updates',1,1,now());

insert into additionaldocsvalues (additionalDocValue,additionalDoc_docId,application_applicationId) values('700',1,1);
