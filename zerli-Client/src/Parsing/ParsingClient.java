package Parsing;

import java.util.ArrayList;

import Entities.ClientCart;
import Entities.Complaint;
import Entities.CreditCard;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.Order;
import Entities.OrdersReport;
import Entities.Product_In_Inventory;
import Entities.RevenueReport;
import Entities.Store;
import Entities.User;
import controlers.CEODistributionOfComplaintsController;
import controlers.CEODistributionOfOrdersController;
import controlers.CEOViewReportsOrdersController;
import controlers.CEOViewReportsRevenueController;
import controlers.CartScreenController;
import controlers.ClientAssemblyProductController;
import controlers.ClientCatalogController;
import controlers.ClientOrderPageController;
import controlers.ClientOrdersController;
import controlers.CustomerEmTableComplaintsScreenController;
import controlers.CustomerEm_Insert_New_Com_Controller;
import controlers.LoginScreenController;
import controlers.ManagerAddAccountController;
import controlers.ManagerFreezeController;
import controlers.ManagerOrdersController;
import controlers.ManagerSendEmailController;
import controlers.ManagerViewReportsOrders;
import controlers.ManagerViewReportsRevenueController;
import controlers.UpdateItemsInCatalogController;
import controlers.PaymentScreenController;
import controlers.StoreEmployee_update_Inventory_controller;
import controlers.StoreEmployee_update_Item_controller;
import controlers.TableComplaintsScreenController;

public class ParsingClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void Message(Object msg) {
		// TODO Auto-generated method stub
		Message receivedMessage = (Message) msg;
		
		switch (receivedMessage.getMessageType()) {

		case userlogin: {
			String[] DivedMsg = ((String) receivedMessage.getMessageData()).split("#");
			if (!receivedMessage.getMessageData().equals("WrongInput")) {
				if (receivedMessage.getMessageData().equals("Already")) {
					LoginScreenController.statusUser = "The user is already logged in";
					LoginScreenController.user = null;
				} else {
					if (receivedMessage.getMessageData().equals("Freeze")) {
						LoginScreenController.statusUser = "Frozen Account";
						LoginScreenController.user = null;
					} else {
						LoginScreenController.user = new User(DivedMsg[0], DivedMsg[1], DivedMsg[2], DivedMsg[3],
								DivedMsg[4], DivedMsg[5], DivedMsg[6],DivedMsg[7],DivedMsg[8],DivedMsg[9]);
						LoginScreenController.statusUser = "Active";
						CartScreenController.cart = new ClientCart();
					}
				}
			} else {
				LoginScreenController.statusUser = "User name or password are inccorect";
				LoginScreenController.user = null;
			}
		}
		
		case ConfirmOpenNewAccount: {
			ManagerAddAccountController.ConfirmOpenNewAccountFlag = true;
			break;
		}
		case Initialize_Catalog_succ :{
			ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
			Catalog = (ArrayList<Item_In_Catalog>) (receivedMessage.getMessageData());
			if(Catalog.get(0).isAssembleItem().compareTo("0")==0) {
				ClientCatalogController.Catalog=Catalog;
				ClientCatalogController.catalog_Initilaize = true;
			}
			else {
				ClientAssemblyProductController.Catalog=Catalog;
				ClientAssemblyProductController.catalog_Initilaize = true;
			}
		}
		case getYear: {
			ManagerViewReportsRevenueController.years = (ArrayList<String>) receivedMessage.getMessageData();
			break;
		}
		case getMonth: {
			ManagerViewReportsRevenueController.months = (ArrayList<String>) receivedMessage.getMessageData();
			break;
		}
		case RevenueReports_succ: {
			ManagerViewReportsRevenueController.revenue = (ArrayList<RevenueReport>)(receivedMessage.getMessageData());
			break;
		}
		case getTypeProduct_succ: {
			ManagerViewReportsOrders.productType = (ArrayList<String>)(receivedMessage.getMessageData());
			break;
		}
		case getTypeProductOrders_succ: {
			ManagerViewReportsOrders.productTypeOrders = (ArrayList<OrdersReport>)(receivedMessage.getMessageData());
			break;
		}
		case getCustomerToFreeze_succ:{
			ManagerFreezeController.customerList =  (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getHomwStore_succ:{
			ManagerFreezeController.customerList = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getNamesitems_succ:{
			UpdateItemsInCatalogController.NamesproductList = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getTypeProductForCatalog_succ:{
			UpdateItemsInCatalogController.productType1 = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case InitialShopsList_succ :{
			ArrayList<Store> stores= new ArrayList<>();
			stores = (ArrayList<Store>) (receivedMessage.getMessageData());
			ClientOrderPageController.storesList = stores;
		}
		case CreditCardList_succ :{
			PaymentScreenController.cardList =  (ArrayList<CreditCard>) (receivedMessage.getMessageData());
		break;
		}
		case CreditValue_succ :{
			PaymentScreenController.CreditAmmount =receivedMessage.getMessageData() ;
		
		}
		case CreditUsed_succ:{
			break;
		}
		
		case Add_New_Payment_Method_succ:{
			break;
		}
		case Add_Order_succ:{
			PaymentScreenController.OrderNum= receivedMessage.getMessageData();	
		break;
		}
		case IsNewClient_succ:{
			PaymentScreenController.newClient= receivedMessage.getMessageData();		
		}
		case UpdateNewClientDiscount_succ:{
			
		}
		case Get_All_Order_by_id_succ:{
			ClientOrdersController.list = (ArrayList<Order>) (receivedMessage.getMessageData());
		}
		case Get_Orders_by_Store_succ :{
			ManagerOrdersController.listOfOrders = (ArrayList<Order>) (receivedMessage.getMessageData());
		    break;
		}
		case getRecipt_succ:{
			ClientOrdersController.recipt =  (ArrayList<String>)( receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getIdFromComplaitnDB_succ:{
			TableComplaintsScreenController.listID = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getTableComplaintsFromDB_succ:{
			TableComplaintsScreenController.listTable = (ArrayList<Complaint>)(receivedMessage.getMessageData());
		}

		case getHomwStoreForCEOordersReports_succ:{
			CEOViewReportsOrdersController.stores = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		
		case getTypeProductForCEOordersReports_succ:{
			CEOViewReportsOrdersController.types = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getCEOordersReports_succ:{
			CEOViewReportsOrdersController.reports = (ArrayList<OrdersReport>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getHomwStoreForCEORevenenueReports_succ: {
			CEOViewReportsRevenueController.stores = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case getRevenueReportForCEO_succ: {
			CEOViewReportsRevenueController.revenue = (ArrayList<RevenueReport>)(receivedMessage.getMessageData());
		}
		case UpdateCompList_succ:{
			CustomerEmTableComplaintsScreenController.complaints = (ArrayList<Complaint>) (receivedMessage.getMessageData());
			break;
		}
		case  RefundForClient_succ:{
			ManagerOrdersController.ammount =  receivedMessage.getMessageData();
			break;
		}
		case ClientExist_succ:{
			CustomerEm_Insert_New_Com_Controller.ClientEx=!((ArrayList<String>) (receivedMessage.getMessageData())).isEmpty();
		}
		case ClientEmailAndPhone_succ :{
			 ManagerSendEmailController.email_phone = (ArrayList<String>) (receivedMessage.getMessageData());
				break;
		}
		case Get_All_Items_In_Catalog_succ :{
			 StoreEmployee_update_Item_controller.All_Items_In_Catalog =(ArrayList<Item_In_Catalog>) (receivedMessage.getMessageData());
			 break;
		}
		case get_Inventories_succ:{
			StoreEmployee_update_Inventory_controller.Inventories = (ArrayList<Product_In_Inventory>) (receivedMessage.getMessageData());
			 break;
		}
		//liraz-4.6 - not exist on dana git
		case getHomwStoreForCEORDistributionOfOrders_succ:{
			CEODistributionOfOrdersController.stores = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		///liraz-4.6 - not exist on dana git
		case getYearsForCEORDistributionOfOrders_succ:{
			CEODistributionOfOrdersController.years = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		//liraz-4.6 - not exist on dana git
		case SetDetailsInTable1ForCEOordersDistribution_succ:{
			CEODistributionOfOrdersController.income = (String) receivedMessage.getMessageData();
		}
		//liraz-4.6 - not exist on dana git
		case getForCEOComplaintsDistribution_succ: {
			CEODistributionOfComplaintsController.counter = (int)receivedMessage.getMessageData();
		}
		default:{
			break;
		}
  }
}
	
	
}