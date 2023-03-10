--------------------------------------------------------
--  DDL for Table REGION_CITY
--------------------------------------------------------

  CREATE TABLE "C##MYHOME"."REGION_CITY" 
   (	"CITY_NM" VARCHAR2(30 BYTE), 
	"CITY_CODE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "C##MYHOME"."REGION_CITY"."CITY_NM" IS '시도 이름';
   COMMENT ON COLUMN "C##MYHOME"."REGION_CITY"."CITY_CODE" IS '시도 코드';
--------------------------------------------------------
--  DDL for Table REGION_COUNTY
--------------------------------------------------------

  CREATE TABLE "C##MYHOME"."REGION_COUNTY" 
   (	"COUNTY_NM" VARCHAR2(30 BYTE), 
	"COUNTY_CODE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "C##MYHOME"."REGION_COUNTY"."COUNTY_NM" IS '시군구 이름';
   COMMENT ON COLUMN "C##MYHOME"."REGION_COUNTY"."COUNTY_CODE" IS '시군구 코드';
--------------------------------------------------------
--  DDL for Table REGION_DISTRICTS
--------------------------------------------------------

  CREATE TABLE "C##MYHOME"."REGION_DISTRICTS" 
   (	"DISTRICTS_NM" VARCHAR2(30 BYTE), 
	"DISTRICTS_CODE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "C##MYHOME"."REGION_DISTRICTS"."DISTRICTS_NM" IS '읍면동_이름';
   COMMENT ON COLUMN "C##MYHOME"."REGION_DISTRICTS"."DISTRICTS_CODE" IS '읍면동_코드';
--------------------------------------------------------
--  DDL for Index REGION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MYHOME"."REGION_PK" ON "C##MYHOME"."REGION_CITY" ("CITY_NM", "CITY_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REGION_COUNTY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MYHOME"."REGION_COUNTY_PK" ON "C##MYHOME"."REGION_COUNTY" ("COUNTY_NM", "COUNTY_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REGION_DISTRICTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##MYHOME"."REGION_DISTRICTS_PK" ON "C##MYHOME"."REGION_DISTRICTS" ("DISTRICTS_NM", "DISTRICTS_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table REGION_CITY
--------------------------------------------------------

  ALTER TABLE "C##MYHOME"."REGION_CITY" MODIFY ("CITY_NM" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_CITY" MODIFY ("CITY_CODE" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_CITY" ADD CONSTRAINT "REGION_PK" PRIMARY KEY ("CITY_NM", "CITY_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REGION_COUNTY
--------------------------------------------------------

  ALTER TABLE "C##MYHOME"."REGION_COUNTY" MODIFY ("COUNTY_CODE" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_COUNTY" MODIFY ("COUNTY_NM" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_COUNTY" ADD CONSTRAINT "REGION_COUNTY_PK" PRIMARY KEY ("COUNTY_NM", "COUNTY_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REGION_DISTRICTS
--------------------------------------------------------

  ALTER TABLE "C##MYHOME"."REGION_DISTRICTS" MODIFY ("DISTRICTS_NM" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_DISTRICTS" MODIFY ("DISTRICTS_CODE" NOT NULL ENABLE);
  ALTER TABLE "C##MYHOME"."REGION_DISTRICTS" ADD CONSTRAINT "REGION_DISTRICTS_PK" PRIMARY KEY ("DISTRICTS_NM", "DISTRICTS_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
