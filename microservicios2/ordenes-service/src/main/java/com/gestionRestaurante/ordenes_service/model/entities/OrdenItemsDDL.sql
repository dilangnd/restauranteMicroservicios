CREATE OR REPLACE TABLE ORDEN_ITEM (
ID LONG NOT NULL,
SKU VARCHAR NOT NULL,
QUANTITY LONG NOT NULL,
ID_ORDEN LONG NOT NULL,
CONSTRAINT ORDEN_ITEM_ID_PK PRIMARY KEY(ID)
);