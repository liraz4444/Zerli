package Entities;

public enum MessageType {

	/*Server Message*/
	Update_succesfuly,Show_Orders_succ,login,Disconected,Update_Not_succesfuly,Initialize_Catalog_succ,
	
	/*Client Message*/
	Update_Orders,Show_Orders,Show_Catalog,userlogin,add_account,ShowRevenueReport,ConfirmOpenNewAccount,Initialize_Catalog,
	getYear,getRevenueReports,RevenueReports_succ,getMonth, getTypeProduct,
	
	
	Error, getTypeProduct_succ, getTypeOrders, getTypeProductOrders_succ, getCustomerToFreeze, getCustomerToFreeze_succ, customerFreeze, getHomeStore, getHomwStore_succ,
	getTypeNames, getNamesitems_succ, UpdatePriceToItem,getTypeProductForUpdateCatalog,getTypeProductForCatalog_succ, getTypeProductForUpdateCatalog1,
	getIdFromComplaitnDB, getIdFromComplaitnDB_succ, ShowTableComlaintInDB, getTableComplaintsFromDB_succ, setRefundToClient, GetStore,
	getStore_succ, getTypesForCEOordersReports, getTypeProductForCEOordersReports_succ, getStoresForCEOordersReports, getHomwStoreForCEOordersReports_succ, getCEOordersReport, getCEOordersReports_succ, 
	InitialShopsList, CreditCardList, CreditValue, CreditUsed, Add_New_Payment_Method, Add_Order, IsNewClient, UpdateNewClientDiscount, UpdateNewClientDiscount_succ, IsNewClient_succ,
	Add_Order_succ, Add_New_Payment_Method_succ, CreditUsed_succ, CreditValue_succ, CreditCardList_succ, InitialShopsList_succ, Add_Recipt, Add_Recipt_succ, Get_All_Order_by_id, Get_All_Order_by_id_succ, getRecipt, getRecipt_succ, Get_All_Order_by_Store, UpdateOrderStatus, UpdateOrderStatus_succ, Get_All_Order_by_Store_succ,
	getStoresForCEORevenueReports, getHomwStoreForCEORevenenueReports_succ, showRevenueReportsForCEO, getRevenueReportForCEO_succ, Get_Orders_by_Store, UpdateCreditForClient, UpdateOrderCancel, UpdateCompList, Update_refund, UpdateCompLaintDetails, Upload_Complaint, ClientExist, UpdateCompList_succ, ClientExist_succ, Upload_Complaint_succ, UpdateOrderCancel_succ, Get_Orders_by_Store_succ, getStoresForCEOordersDistribution, getQuarterlyForCEOordersDistribution, getHomwStoreForCEORDistributionOfOrders_succ, SetDetailsInTable1ForCEOordersDistribution, getYearsForCEOordersDistribution, getYearsForCEORDistributionOfOrders_succ, SetDetailsInTable1ForCEOordersDistribution_succ, getYearsForCEOComplaintsDistribution, getYearsForCEOComplaintsDistribution_succ, getForCEOComplaintsDistribution, getForCEOComplaintsDistribution_succ, UpdateQuanInInventory, getClientEmailAndPhone, get_Inventories, Get_All_Items_In_Catalog, RefundForClient_succ, ClientEmailAndPhone_succ, Get_All_Items_In_Catalog_succ, get_Inventories_succ,
}