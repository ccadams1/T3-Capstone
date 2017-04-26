INSERT INTO USER_ROLE
VALUES('ADMINISTRATOR');
INSERT INTO USER_ROLE
VALUES('OVERALL MANAGER');
INSERT INTO USER_ROLE
VALUES('INVENTORY MANAGER');
INSERT INTO USER_ROLE
VALUES('POS MANAGER');
INSERT INTO USER_ROLE
VALUES('INVENTORY USER');
INSERT INTO USER_ROLE
VALUES('POS USER');

DECLARE @responseMessage NVARCHAR(250), @UserID INT

EXEC dbo.uspAddUser
	@pLogin = N'Admin',
	@pPassword = N'123',
	@pFirstName = N'Admin',
	@pLastName = N'Administrator',
	@pURE_ID = N'1',
	@pEmail = N'Admin@XXXXX',
	@pPhone1 = NULL,
	@pRemoved = N'0',
	@responseMessage=@responseMessage OUTPUT,
	@UserID=@UserID OUTPUT

SELECT	@responseMessage as N'@responseMessage'
SELECT  @UserID as N'@UserID'