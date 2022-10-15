export interface ItemRequestDetails{
  itemRequestDetailsId:String;
  quantityPackage:String;
  quantity:String;
  itemRequest:{
    itemRequestId:String;
  }
  items:{
    itemsId:string
  }
  deleteFlag: number;

};
