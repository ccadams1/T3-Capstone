USE [master]
GO
/****** Object:  Database [T3_TI_WTCC]    Script Date: 4/25/2017 6:43:30 PM ******/
CREATE DATABASE [T3_TI_WTCC]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [T3_TI_WTCC].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [T3_TI_WTCC] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET ARITHABORT OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [T3_TI_WTCC] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [T3_TI_WTCC] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [T3_TI_WTCC] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET  ENABLE_BROKER 
GO
ALTER DATABASE [T3_TI_WTCC] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET ALLOW_SNAPSHOT_ISOLATION ON 
GO
ALTER DATABASE [T3_TI_WTCC] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [T3_TI_WTCC] SET READ_COMMITTED_SNAPSHOT ON 
GO
ALTER DATABASE [T3_TI_WTCC] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [T3_TI_WTCC] SET RECOVERY FULL 
GO
ALTER DATABASE [T3_TI_WTCC] SET  MULTI_USER 
GO
ALTER DATABASE [T3_TI_WTCC] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [T3_TI_WTCC] SET DB_CHAINING OFF 
GO
USE [T3_TI_WTCC]
GO
/****** Object:  StoredProcedure [dbo].[SalesByDate]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[SalesByDate] (@fromDate NVARCHAR(25), @toDATE NVARCHAR(25))
AS

SELECT I.ivcID, I.RTN_id, I.payment_type, I.invoice_total, RT.sale_date, RT.CUS_ID, C.lname, C.fname, U.LoginName,
	CASE 
	WHEN I.ivc_open = 1 THEN 'Open'
	WHEN I.ivc_open = 0 THEN 'Paid'
	END AS 'Status'
FROM INVOICE I
LEFT OUTER JOIN RETAIL_TRANSACTION RT
ON I.RTN_id = RT.rtnID
LEFT OUTER JOIN CUSTOMER C
ON RT.CUS_ID = C.cusID
LEFT OUTER JOIN USERS U
ON RT.USER_id = U.UserID
---WHERE THE SALE DATE EQUALS TODAY'S DATE
---WHERE CAST(CONVERT(VARCHAR,RT.sale_date,101) AS DATETIME) >= CAST(CONVERT(VARCHAR,@fromDate,101) AS DATETIME)
---AND CAST(CONVERT(VARCHAR,RT.sale_date,101) AS DATETIME) <= CAST(CONVERT(VARCHAR,@fromDate,101) AS DATETIME)
WHERE RT.sale_date >= @fromDate
AND RT.sale_date <= @fromDate

GO
/****** Object:  StoredProcedure [dbo].[uspAddCustomer]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspAddCustomer]
	@pFname VARCHAR(50) = NULL,
	@pLname VARCHAR(50) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@responseMessage VARCHAR(250) OUTPUT,
	@CusID INT OUTPUT

AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO CUSTOMER (fname, lname, st_address1, st_address2, city, state, zip_code, phone1, phone2, website, email, fax)
		VALUES(@pFname, @pLname, @pSt_Address1, @pSt_Address2, @pCity, @pState, @pZip_Code, @pPhone1, @pPhone2, @pWebsite, @pEmail, @pFax)

		SELECT @CusID = cusID
		FROM CUSTOMER
		WHERE fname = @pFname
		AND lname = @pLname
		AND st_address1 = @pSt_Address1

		SET @responseMessage='Success!' + '  Customer ID is: ' + CONVERT(VARCHAR(10), @CusID) + ' for Customer: ' + @pFname + ' ' + @pLname

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspAddInventory]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspAddInventory]
	@pUpcCode BIGINT = NULL,
	@pItemName NVARCHAR(50) = NULL,
	@pItemDescription NVARCHAR(125) = NULL,
	@pNum_in_Stock INT = NULL,
	@pReorder_Amt INT = NULL,
	@pRetailPrice MONEY = NULL,
	@pSUP_id INT = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT,
	@invID INT OUTPUT

AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO INVENTORY (upc_code, item_name, item_description, num_in_stock, reorder_amt, retail_price, SUP_id, removed)
		VALUES(@pUpcCode, @pItemName, @pItemDescription, @pNum_in_Stock, @pReorder_Amt, @pRetailPrice, @pSUP_id, @pRemoved)

		SELECT @invID = invID
		FROM INVENTORY
		WHERE item_name = @pItemName

		SET @responseMessage='Success!' + '  Inventory ID is: ' + CONVERT(VARCHAR(10), @invID) + ' for Item: ' + @pItemName

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspAddInvoice]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspAddInvoice]
	@IvcId int OUTPUT, 
	@pRtnId int = NULL,
	@pIvcOpen bit = NULL,
	@pPymtType NVARCHAR(25) = NULL,
	@pIvcTtl money = NULL,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO INVOICE (RTN_id, ivc_open, payment_type, invoice_total)
		VALUES(@pRtnId, @pIvcOpen, @pPymtType, @pIvcTtl)

		SELECT @IvcId = ivcID
		FROM INVOICE
		WHERE RTN_id = @pRtnId
		AND ivc_open = @pIvcOpen
		AND payment_type = @pPymtType
		AND invoice_total = @pIvcTtl

		SET @responseMessage='Success!' + ' Invoice ID is: ' + CONVERT(VARCHAR(10), @IvcId)

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END


GO
/****** Object:  StoredProcedure [dbo].[uspAddMyBusiness]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspAddMyBusiness]
	@pBiz_Name VARCHAR(125) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pLogo1 IMAGE = NULL,
	@pLogo2 IMAGE = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@pOwner_fName VARCHAR(50) = NULL,
	@pOwner_lName VARCHAR(50) = NULL,
	@responseMessage VARCHAR(250) OUTPUT

AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO MY_BUSINESS (biz_name, st_address1, st_address2, city, state, zip_code, logo1, logo2, phone1, phone2, website, email, fax, owner_fname, owner_lname)
		VALUES(@pBiz_Name, @pSt_Address1, @pSt_Address2, @pCity, @pState, @pZip_Code, @pLogo1, @pLogo2, @pPhone1, @pPhone2, @pWebsite, @pEmail, @pFax, @pOwner_fName, @pOwner_lName)

		SET @responseMessage='Success! The business information has been added.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspAddRetailTranItem]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspAddRetailTranItem]
	@pRtnId int = NULL, 
	@pInvId int = NULL,
	@pNumPurch int = NULL,
	@pPrice money = NULL,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO RETAIL_TRAN_ITEM (RTN_id, INV_id, num_purchased, price)
		VALUES(@pRtnId, @pInvId, @pNumPurch, @pPrice)
		
		SET @responseMessage='Success!' + ' Retail Transaction Item added: ' + 
		CONVERT(VARCHAR(10), @pRtnId) + ', ' +
		CONVERT(VARCHAR(10), @pInvId) + ', ' +
		CONVERT(VARCHAR(10), @pNumPurch) + ', ' +
		CONVERT(VARCHAR(25), @pPrice) + '.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END


GO
/****** Object:  StoredProcedure [dbo].[uspAddRetailTransaction]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspAddRetailTransaction]
	@rtnID int OUTPUT, 
	@pSaleDate date = NULL, 
	@pCusId int = NULL, 
	@pUserId int = NULL,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO RETAIL_TRANSACTION (sale_date, CUS_ID, USER_id)
		VALUES(@pSaleDate, @pCusId, @pUserId)

		SELECT @rtnID = rtnID
		FROM RETAIL_TRANSACTION
		WHERE sale_date = @pSaleDate
		AND CUS_ID = @pCusId
		AND USER_id = @pUserId

		SET @responseMessage='Success!' + ' Retail Transaction ID is: ' + CONVERT(VARCHAR(10), @rtnID)

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END


GO
/****** Object:  StoredProcedure [dbo].[uspAddSupplier]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspAddSupplier]
	@pName NVARCHAR(125) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pLogo IMAGE = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT,
	@SupID INT OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		INSERT INTO SUPPLIER (name, st_address1, st_address2, city, s_state, zip_code, logo, phone1, phone2, website, email, fax, removed)
		VALUES(@pName, @pSt_Address1, @pSt_Address2, @pCity, @pState, @pZip_Code, @pLogo, @pPhone1, @pPhone2, @pWebsite, @pEmail, @pFax, @pRemoved)

		SELECT @SupID = supID
		FROM SUPPLIER
		WHERE name = @pName

		SET @responseMessage='Success!' + '  Supplier ID is: ' + CONVERT(VARCHAR(10), @SupID) + ' for Supplier: ' + @pName

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspAddUser]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspAddUser]
	@pLogin NVARCHAR(50),
	@pPassword NVARCHAR(50),
	@pFirstName VARCHAR(40) = NULL,
	@pLastName VARCHAR(40) = NULL,
	@pURE_ID INT = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT,
	@UserID INT OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	DECLARE @salt UNIQUEIDENTIFIER=NEWID()
	BEGIN TRY

		INSERT INTO USERS (LoginName, PasswordHash, Salt, FirstName, LastName, URE_ID, Email, Phone1, Removed)
		VALUES(@pLogin, HASHBYTES('SHA2_512', @pPassword+CAST(@salt AS NVARCHAR(36))), @salt, @pFirstName, @pLastName, @pURE_ID, @pEmail, @pPhone1, @pRemoved)

		--SET @UserID INT
		SELECT @UserID = UserID
		FROM USERS
		WHERE LoginName = @pLogin

		SET @responseMessage='Success!' + '  User ID is: ' + CONVERT(VARCHAR(10), @UserID) + ' for User Login: ' + @pLogin

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END


GO
/****** Object:  StoredProcedure [dbo].[uspEditCustomer]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[uspEditCustomer]
	@pCusID INT = NULL,
	@pFname VARCHAR(50) = NULL,
	@pLname VARCHAR(50) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		UPDATE CUSTOMER 
		SET
		fname = @pFname,
		lname = @pLname, 
		st_address1 = @pSt_Address1, 
		st_address2 = @pSt_Address2, 
		city = @pCity, 
		state = @pState, 
		zip_code = @pZip_Code, 
		phone1 = @pPhone1, 
		phone2 = @pPhone2, 
		website = @pWebsite, 
		email = @pEmail, 
		fax =@pFax 
		WHERE
		@pCusID = cusID
		
		SET @responseMessage='Success!' + '  Customer ID ' + CONVERT(VARCHAR(10), @pCusID) + ' has been updated.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END




GO
/****** Object:  StoredProcedure [dbo].[uspEditInventory]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[uspEditInventory]
	@pinvID INT = NULL,
	@pUpcCode BIGINT = NULL,
	@pItemName NVARCHAR(50) = NULL,
	@pItemDescription NVARCHAR(125) = NULL,
	@pNum_in_Stock INT = NULL,
	@pReorder_Amt INT = NULL,
	@pRetailPrice MONEY = NULL,
	@pSUP_id INT = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT

AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		UPDATE INVENTORY 
		SET 
		upc_code = @pUpcCode,
		item_name = @pItemName,
		item_description = @pItemDescription,
		num_in_stock = @pNum_in_Stock,
		reorder_amt = @pReorder_Amt,
		retail_price = @pRetailPrice,
		SUP_id = @pSUP_id,
		removed = @pRemoved
		WHERE
		@pinvID = invID

		SET @responseMessage='Success!' + '  Inventory ID ' + CONVERT(VARCHAR(10), @pinvID) + ' has been updated.'
		

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END




GO
/****** Object:  StoredProcedure [dbo].[uspEditMyBusiness]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspEditMyBusiness]
	@pBiz_Name VARCHAR(125) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pLogo1 IMAGE = NULL,
	@pLogo2 IMAGE = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@pOwner_fName VARCHAR(50) = NULL,
	@pOwner_lName VARCHAR(50) = NULL,
	@responseMessage VARCHAR(250) OUTPUT

AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		UPDATE MY_BUSINESS 
		SET
		biz_name = @pBiz_Name, 
		st_address1 = @pSt_Address1, 
		st_address2 = @pSt_Address2, 
		city = @pCity, 
		state = @pState, 
		zip_code = @pZip_Code, 
		logo1 = @pLogo1, 
		logo2 = @pLogo2, 
		phone1 = @pPhone1, 
		phone2 = @pPhone2, 
		website = @pWebsite, 
		email = @pEmail, 
		fax = @pFax, 
		owner_fname = @pOwner_fName, 
		owner_lname = @pOwner_lName
		
		SET @responseMessage='Success! The business information has been updated.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspEditSupplier]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[uspEditSupplier]
	@pSupID INT = NULL,
	@pName NVARCHAR(125) = NULL,
	@pSt_Address1 VARCHAR(125) = NULL,
	@pSt_Address2 VARCHAR(125) = NULL,
	@pCity VARCHAR(50) = NULL,
	@pState VARCHAR(2) = NULL,
	@pZip_Code INT = NULL,
	@pLogo IMAGE = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pPhone2 VARCHAR(25) = NULL,
	@pWebsite VARCHAR(50) = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pFax VARCHAR(25) = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	BEGIN TRY

		UPDATE SUPPLIER 
		SET
		name = @pName, 
		st_address1 = @pSt_Address1, 
		st_address2 = @pSt_Address2, 
		city = @pCity, 
		s_state = @pState, 
		zip_code = @pZip_Code, 
		logo = @pLogo, 
		phone1 = @pPhone1, 
		phone2 = @pPhone2, 
		website = @pWebsite, 
		email = @pEmail, 
		fax =@pFax, 
		removed = @pRemoved
		WHERE
		@pSupID = supID
		
		SET @responseMessage='Success!' + '  Supplier ID ' + CONVERT(VARCHAR(10), @pSupID) + ' has been updated.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END




GO
/****** Object:  StoredProcedure [dbo].[uspEditUser]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspEditUser]
	@pUserID INT = NULL,
	@pLogin NVARCHAR(50),
	@pPassword NVARCHAR(50),
	@pFirstName VARCHAR(40) = NULL,
	@pLastName VARCHAR(40) = NULL,
	@pURE_ID INT = NULL,
	@pEmail VARCHAR(25) = NULL,
	@pPhone1 VARCHAR(25) = NULL,
	@pRemoved BIT = 0,
	@responseMessage VARCHAR(250) OUTPUT
AS
BEGIN
	SET NOCOUNT ON

	DECLARE @salt UNIQUEIDENTIFIER=NEWID()
	BEGIN TRY

		UPDATE USERS 
		SET 
		LoginName = @pLogin, 
		PasswordHash = HASHBYTES('SHA2_512', @pPassword+CAST(@salt AS NVARCHAR(36))), 
		Salt = @salt, 
		FirstName = @pFirstName, 
		LastName = @pLastName, 
		URE_ID = @pURE_ID, 
		Email = @pEmail, 
		Phone1 = @pPhone1, 
		Removed = @pRemoved
		WHERE
		@pUserID = UserID

		SET @responseMessage='Success!' + '  User ID ' + CONVERT(VARCHAR(10), @pUserID) + ' has been updated.'

	END TRY

	BEGIN CATCH
		SET @responseMessage=ERROR_MESSAGE()
	END CATCH
END



GO
/****** Object:  StoredProcedure [dbo].[uspLogin]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[uspLogin]
    @pLogin NVARCHAR(254),
    @pPassword NVARCHAR(50),
    @responseMessage NVARCHAR(250)='' OUTPUT
AS
BEGIN

    SET NOCOUNT ON

    DECLARE @userID INT

    IF EXISTS (SELECT TOP 1 UserID FROM USERS WHERE LoginName=@pLogin)
    BEGIN
        SET @userID=(SELECT UserID FROM USERS WHERE LoginName=@pLogin AND PasswordHash=HASHBYTES('SHA2_512', @pPassword+CAST(Salt AS NVARCHAR(36))))

       IF(@userID IS NULL)
           SET @responseMessage='Incorrect password'
       ELSE 
           SET @responseMessage='User successfully logged in'
    END
    ELSE
       SET @responseMessage='Invalid login'

END
GO
/****** Object:  Table [dbo].[CUSTOMER]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUSTOMER](
	[cusID] [int] IDENTITY(1,1) NOT NULL,
	[fname] [varchar](50) NOT NULL,
	[lname] [varchar](50) NOT NULL,
	[st_address1] [varchar](125) NOT NULL,
	[st_address2] [varchar](125) NULL,
	[city] [varchar](50) NOT NULL,
	[state] [varchar](2) NOT NULL,
	[zip_code] [int] NULL,
	[phone1] [varchar](25) NULL,
	[phone2] [varchar](25) NULL,
	[website] [varchar](50) NULL,
	[email] [varchar](25) NULL,
	[fax] [varchar](25) NULL,
PRIMARY KEY CLUSTERED 
(
	[cusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON),
UNIQUE NONCLUSTERED 
(
	[fname] ASC,
	[lname] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INVENTORY]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[INVENTORY](
	[invID] [int] IDENTITY(1,1) NOT NULL,
	[upc_code] [bigint] NULL,
	[item_name] [nvarchar](50) NOT NULL,
	[item_description] [nvarchar](125) NOT NULL,
	[num_in_stock] [int] NOT NULL,
	[reorder_amt] [int] NOT NULL,
	[retail_price] [money] NOT NULL,
	[SUP_id] [int] NOT NULL,
	[removed] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[invID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[INVOICE]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[INVOICE](
	[ivcID] [int] IDENTITY(1,1) NOT NULL,
	[RTN_id] [int] NOT NULL,
	[ivc_open] [bit] NOT NULL,
	[payment_type] [nvarchar](25) NOT NULL,
	[invoice_total] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ivcID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[MY_BUSINESS]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MY_BUSINESS](
	[biz_name] [varchar](125) NOT NULL,
	[st_address1] [varchar](125) NOT NULL,
	[st_address2] [varchar](125) NULL,
	[city] [varchar](50) NOT NULL,
	[state] [varchar](2) NOT NULL,
	[zip_code] [int] NOT NULL,
	[logo1] [image] NULL,
	[logo2] [image] NULL,
	[phone1] [varchar](25) NULL,
	[phone2] [varchar](25) NULL,
	[website] [varchar](50) NULL,
	[email] [varchar](25) NULL,
	[fax] [varchar](25) NULL,
	[owner_fname] [varchar](50) NOT NULL,
	[owner_lname] [varchar](50) NOT NULL
)

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETAIL_TRAN_ITEM]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RETAIL_TRAN_ITEM](
	[RTN_id] [int] NOT NULL,
	[INV_id] [int] NOT NULL,
	[num_purchased] [int] NOT NULL,
	[price] [money] NOT NULL,
 CONSTRAINT [PK_RetailTranItem] PRIMARY KEY NONCLUSTERED 
(
	[RTN_id] ASC,
	[INV_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[RETAIL_TRANSACTION]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RETAIL_TRANSACTION](
	[rtnID] [int] IDENTITY(1,1) NOT NULL,
	[sale_date] [date] NOT NULL,
	[CUS_ID] [int] NOT NULL,
	[USER_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[rtnID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[SUPPLIER]    Script Date: 4/25/2017 6:43:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SUPPLIER](
	[supID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](125) NOT NULL,
	[st_address1] [varchar](125) NOT NULL,
	[st_address2] [varchar](125) NULL,
	[city] [varchar](50) NOT NULL,
	[s_state] [varchar](2) NOT NULL,
	[zip_code] [int] NOT NULL,
	[logo] [image] NULL,
	[phone1] [varchar](25) NULL,
	[phone2] [varchar](25) NULL,
	[website] [varchar](50) NULL,
	[email] [varchar](25) NULL,
	[fax] [varchar](25) NULL,
	[removed] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[supID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON),
UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USER_PERMISSION]    Script Date: 4/25/2017 6:43:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USER_PERMISSION](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[URE_ID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USER_ROLE]    Script Date: 4/25/2017 6:43:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USER_ROLE](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
 CONSTRAINT [PK__USER_ROL] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USERS]    Script Date: 4/25/2017 6:43:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USERS](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[LoginName] [nvarchar](50) NOT NULL,
	[URE_ID] [int] NULL,
	[FirstName] [nvarchar](40) NOT NULL,
	[LastName] [nvarchar](40) NOT NULL,
	[email] [nvarchar](25) NOT NULL,
	[phone1] [varchar](25) NULL,
	[PasswordHash] [binary](64) NOT NULL,
	[Salt] [uniqueidentifier] NULL,
	[removed] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON),
 CONSTRAINT [uc_USERS_LoginName] UNIQUE NONCLUSTERED 
(
	[LoginName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[INVENTORY] ADD  CONSTRAINT [INVremovedDefaultValue]  DEFAULT ((0)) FOR [removed]
GO
ALTER TABLE [dbo].[SUPPLIER] ADD  CONSTRAINT [SUPremovedDefaultValue]  DEFAULT ((0)) FOR [removed]
GO
ALTER TABLE [dbo].[USERS] ADD  CONSTRAINT [removedDefaultValue]  DEFAULT ((0)) FOR [removed]
GO
ALTER TABLE [dbo].[INVENTORY]  WITH CHECK ADD  CONSTRAINT [FK_SupplierID] FOREIGN KEY([SUP_id])
REFERENCES [dbo].[SUPPLIER] ([supID])
GO
ALTER TABLE [dbo].[INVENTORY] CHECK CONSTRAINT [FK_SupplierID]
GO
ALTER TABLE [dbo].[INVOICE]  WITH CHECK ADD FOREIGN KEY([RTN_id])
REFERENCES [dbo].[RETAIL_TRANSACTION] ([rtnID])
GO
ALTER TABLE [dbo].[RETAIL_TRAN_ITEM]  WITH CHECK ADD FOREIGN KEY([INV_id])
REFERENCES [dbo].[INVENTORY] ([invID])
GO
ALTER TABLE [dbo].[RETAIL_TRAN_ITEM]  WITH CHECK ADD FOREIGN KEY([RTN_id])
REFERENCES [dbo].[RETAIL_TRANSACTION] ([rtnID])
GO
ALTER TABLE [dbo].[RETAIL_TRANSACTION]  WITH CHECK ADD FOREIGN KEY([CUS_ID])
REFERENCES [dbo].[CUSTOMER] ([cusID])
GO
ALTER TABLE [dbo].[RETAIL_TRANSACTION]  WITH CHECK ADD  CONSTRAINT [FK_UserID] FOREIGN KEY([USER_id])
REFERENCES [dbo].[USERS] ([UserID])
GO
ALTER TABLE [dbo].[RETAIL_TRANSACTION] CHECK CONSTRAINT [FK_UserID]
GO
ALTER TABLE [dbo].[USER_PERMISSION]  WITH CHECK ADD  CONSTRAINT [FK_USER_PERM_URE_ID] FOREIGN KEY([URE_ID])
REFERENCES [dbo].[USER_ROLE] ([ID])
GO
ALTER TABLE [dbo].[USER_PERMISSION] CHECK CONSTRAINT [FK_USER_PERM_URE_ID]
GO
ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [FK_USER_URE_ID] FOREIGN KEY([URE_ID])
REFERENCES [dbo].[USER_ROLE] ([ID])
GO
ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [FK_USER_URE_ID]
GO
USE [master]
GO
ALTER DATABASE [T3_TI_WTCC] SET  READ_WRITE 
GO
