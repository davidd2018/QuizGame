create database QuizGame
go
use QuizGame
go

CREATE TABLE Account (
    AccountID INT IDENTITY(1,1) PRIMARY KEY, -- auto-increment ID
    Username NVARCHAR(50) NOT NULL UNIQUE,    -- username must be unique
    Password NVARCHAR(255) NOT NULL,          -- password (store hash, not plain text)
    Avatar NVARCHAR(255) NULL                 -- avatar file path or URL
);

select * from Account