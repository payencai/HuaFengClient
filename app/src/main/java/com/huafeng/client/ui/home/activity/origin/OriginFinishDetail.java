package com.huafeng.client.ui.home.activity.origin;

import java.util.List;

public class OriginFinishDetail {

    /**
     * inventorySample : {"category1Id":0,"category2Id":0,"factoryId":0,"gmtCreate":"2019-06-17T09:35:23.119Z","gmtModified":"2019-06-17T09:35:23.119Z","quantity":0,"sampleId":0,"unitPrice":0}
     * inventorySampleLogList : [{"employeeRecordId":0,"employeeRecordName":"string","factoryId":0,"gmtCreate":"2019-06-17T09:35:23.119Z","id":0,"item":0,"noteId":0,"productionOrderId":0,"quantity":0,"remainingQuantity":0,"remarks":"string","sampleId":0,"title":"string","type":0}]
     * ordersList : [{"clientRecordId":0,"createBy":0,"factoryId":0,"finishBy":0,"gmtCreate":"2019-06-17T09:35:23.119Z","gmtFinish":"2019-06-17T09:35:23.119Z","gmtModified":"2019-06-17T09:35:23.119Z","gmtStop":"2019-06-17T09:35:23.119Z","id":0,"orderNumber":"string","orderSampleId":0,"quantity":0,"remarks":"string","sampleId":0,"shippingAddress":"string","status":0,"stopBy":0,"unitPrice":0}]
     * sampleVo : {"clientRecordId":0,"clientRecordName":"string","color":"string","createBy":0,"designerBy":0,"designerName":"string","factoryId":0,"gmtCreate":"2019-06-17T09:35:23.119Z","gmtModified":"2019-06-17T09:35:23.119Z","id":0,"images":"string","imagesUrl":"string","isDeleted":0,"materialList":[{"factoryId":0,"id":0,"quantity":0,"rawMaterialCategory1Id":0,"rawMaterialCategory1Name":"string","rawMaterialCategory2Id":0,"rawMaterialCategory2Name":"string","rawMaterialId":0,"rawMaterialName":"string","sampleId":0}],"patternNo":"string","productCategory1Id":0,"productCategory1Name":"string","productCategory2Name":"string","productCategoryId":0,"productProcessList":[{"factoryId":0,"id":0,"isOutsourcing":0,"price":0,"processId":0,"processName":"string","sampleId":0,"sequence":0,"stageId":0,"stageName":"string"}],"remarks":"string","sampleNo":"string","sizeList":[{"factoryId":0,"id":0,"sampleId":0,"sampleSizeInformationList":[{"factoryId":0,"id":0,"quantity":0,"sampleId":0,"sampleSizeId":0,"sizeId":0,"sizeInfomationId":0,"sizeInformationName":"string"}],"sizeGroupId":0,"sizeGroupName":"string","sizeId":0,"sizeName":"string"}],"updateBy":0,"washingProcessList":[{"factoryId":0,"id":0,"sampleId":0,"washingProcessId":0,"washingProcessName":"string"}]}
     */

    private InventorySampleBean inventorySample;
    private SampleVoBean sampleVo;
    private List<InventorySampleLogListBean> inventorySampleLogList;
    private List<OrdersListBean> ordersList;
    private List<SizeListBean> sizeList;

    public List<SizeListBean> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<SizeListBean> sizeList) {
        this.sizeList = sizeList;
    }

    public InventorySampleBean getInventorySample() {
        return inventorySample;
    }

    public void setInventorySample(InventorySampleBean inventorySample) {
        this.inventorySample = inventorySample;
    }

    public SampleVoBean getSampleVo() {
        return sampleVo;
    }

    public void setSampleVo(SampleVoBean sampleVo) {
        this.sampleVo = sampleVo;
    }

    public List<InventorySampleLogListBean> getInventorySampleLogList() {
        return inventorySampleLogList;
    }

    public void setInventorySampleLogList(List<InventorySampleLogListBean> inventorySampleLogList) {
        this.inventorySampleLogList = inventorySampleLogList;
    }

    public List<OrdersListBean> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrdersListBean> ordersList) {
        this.ordersList = ordersList;
    }
    public static class SizeListBean {
        /**
         * factoryId : 0
         * inventorySampleLogId : 0
         * quantity : 0
         * sampleId : 0
         * sizeId : 0
         * sizeName : string
         */

        private int factoryId;
        private int inventorySampleLogId;
        private int quantity;
        private int sampleId;
        private int sizeId;
        private String sizeName;

        public int getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(int factoryId) {
            this.factoryId = factoryId;
        }

        public int getInventorySampleLogId() {
            return inventorySampleLogId;
        }

        public void setInventorySampleLogId(int inventorySampleLogId) {
            this.inventorySampleLogId = inventorySampleLogId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getSampleId() {
            return sampleId;
        }

        public void setSampleId(int sampleId) {
            this.sampleId = sampleId;
        }

        public int getSizeId() {
            return sizeId;
        }

        public void setSizeId(int sizeId) {
            this.sizeId = sizeId;
        }

        public String getSizeName() {
            return sizeName;
        }

        public void setSizeName(String sizeName) {
            this.sizeName = sizeName;
        }
    }
    public static class InventorySampleBean {
        /**
         * category1Id : 0
         * category2Id : 0
         * factoryId : 0
         * gmtCreate : 2019-06-17T09:35:23.119Z
         * gmtModified : 2019-06-17T09:35:23.119Z
         * quantity : 0
         * sampleId : 0
         * unitPrice : 0.0
         */

        private int category1Id;
        private int category2Id;
        private int factoryId;
        private String gmtCreate;
        private String gmtModified;
        private int quantity;
        private int sampleId;
        private Double unitPrice;

        public int getCategory1Id() {
            return category1Id;
        }

        public void setCategory1Id(int category1Id) {
            this.category1Id = category1Id;
        }

        public int getCategory2Id() {
            return category2Id;
        }

        public void setCategory2Id(int category2Id) {
            this.category2Id = category2Id;
        }

        public int getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(int factoryId) {
            this.factoryId = factoryId;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(String gmtModified) {
            this.gmtModified = gmtModified;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getSampleId() {
            return sampleId;
        }

        public void setSampleId(int sampleId) {
            this.sampleId = sampleId;
        }

        public Double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    public static class SampleVoBean {
        /**
         * clientRecordId : 0
         * clientRecordName : string
         * color : string
         * createBy : 0
         * designerBy : 0
         * designerName : string
         * factoryId : 0
         * gmtCreate : 2019-06-17T09:35:23.119Z
         * gmtModified : 2019-06-17T09:35:23.119Z
         * id : 0
         * images : string
         * imagesUrl : string
         * isDeleted : 0
         * materialList : [{"factoryId":0,"id":0,"quantity":0,"rawMaterialCategory1Id":0,"rawMaterialCategory1Name":"string","rawMaterialCategory2Id":0,"rawMaterialCategory2Name":"string","rawMaterialId":0,"rawMaterialName":"string","sampleId":0}]
         * patternNo : string
         * productCategory1Id : 0
         * productCategory1Name : string
         * productCategory2Name : string
         * productCategoryId : 0
         * productProcessList : [{"factoryId":0,"id":0,"isOutsourcing":0,"price":0,"processId":0,"processName":"string","sampleId":0,"sequence":0,"stageId":0,"stageName":"string"}]
         * remarks : string
         * sampleNo : string
         * sizeList : [{"factoryId":0,"id":0,"sampleId":0,"sampleSizeInformationList":[{"factoryId":0,"id":0,"quantity":0,"sampleId":0,"sampleSizeId":0,"sizeId":0,"sizeInfomationId":0,"sizeInformationName":"string"}],"sizeGroupId":0,"sizeGroupName":"string","sizeId":0,"sizeName":"string"}]
         * updateBy : 0
         * washingProcessList : [{"factoryId":0,"id":0,"sampleId":0,"washingProcessId":0,"washingProcessName":"string"}]
         */

        private int clientRecordId;
        private String clientRecordName;
        private String color;
        private int createBy;
        private int designerBy;
        private String designerName;
        private int factoryId;
        private String gmtCreate;
        private String gmtModified;
        private int id;
        private String images;
        private String imagesUrl;
        private int isDeleted;
        private String patternNo;
        private int productCategory1Id;
        private String productCategory1Name;
        private String productCategory2Name;
        private int productCategoryId;
        private String remarks;
        private String sampleNo;
        private int updateBy;
        private List<MaterialListBean> materialList;
        private List<ProductProcessListBean> productProcessList;
        private List<SizeListBean> sizeList;
        private List<WashingProcessListBean> washingProcessList;

        public int getClientRecordId() {
            return clientRecordId;
        }

        public void setClientRecordId(int clientRecordId) {
            this.clientRecordId = clientRecordId;
        }

        public String getClientRecordName() {
            return clientRecordName;
        }

        public void setClientRecordName(String clientRecordName) {
            this.clientRecordName = clientRecordName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public int getDesignerBy() {
            return designerBy;
        }

        public void setDesignerBy(int designerBy) {
            this.designerBy = designerBy;
        }

        public String getDesignerName() {
            return designerName;
        }

        public void setDesignerName(String designerName) {
            this.designerName = designerName;
        }

        public int getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(int factoryId) {
            this.factoryId = factoryId;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(String gmtModified) {
            this.gmtModified = gmtModified;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getImagesUrl() {
            return imagesUrl;
        }

        public void setImagesUrl(String imagesUrl) {
            this.imagesUrl = imagesUrl;
        }

        public int getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(int isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getPatternNo() {
            return patternNo;
        }

        public void setPatternNo(String patternNo) {
            this.patternNo = patternNo;
        }

        public int getProductCategory1Id() {
            return productCategory1Id;
        }

        public void setProductCategory1Id(int productCategory1Id) {
            this.productCategory1Id = productCategory1Id;
        }

        public String getProductCategory1Name() {
            return productCategory1Name;
        }

        public void setProductCategory1Name(String productCategory1Name) {
            this.productCategory1Name = productCategory1Name;
        }

        public String getProductCategory2Name() {
            return productCategory2Name;
        }

        public void setProductCategory2Name(String productCategory2Name) {
            this.productCategory2Name = productCategory2Name;
        }

        public int getProductCategoryId() {
            return productCategoryId;
        }

        public void setProductCategoryId(int productCategoryId) {
            this.productCategoryId = productCategoryId;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getSampleNo() {
            return sampleNo;
        }

        public void setSampleNo(String sampleNo) {
            this.sampleNo = sampleNo;
        }

        public int getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(int updateBy) {
            this.updateBy = updateBy;
        }

        public List<MaterialListBean> getMaterialList() {
            return materialList;
        }

        public void setMaterialList(List<MaterialListBean> materialList) {
            this.materialList = materialList;
        }

        public List<ProductProcessListBean> getProductProcessList() {
            return productProcessList;
        }

        public void setProductProcessList(List<ProductProcessListBean> productProcessList) {
            this.productProcessList = productProcessList;
        }

        public List<SizeListBean> getSizeList() {
            return sizeList;
        }

        public void setSizeList(List<SizeListBean> sizeList) {
            this.sizeList = sizeList;
        }

        public List<WashingProcessListBean> getWashingProcessList() {
            return washingProcessList;
        }

        public void setWashingProcessList(List<WashingProcessListBean> washingProcessList) {
            this.washingProcessList = washingProcessList;
        }

        public static class MaterialListBean {
            /**
             * factoryId : 0
             * id : 0
             * quantity : 0
             * rawMaterialCategory1Id : 0
             * rawMaterialCategory1Name : string
             * rawMaterialCategory2Id : 0
             * rawMaterialCategory2Name : string
             * rawMaterialId : 0
             * rawMaterialName : string
             * sampleId : 0
             */

            private int factoryId;
            private int id;
            private Double quantity;
            private int rawMaterialCategory1Id;
            private String rawMaterialCategory1Name;
            private int rawMaterialCategory2Id;
            private String rawMaterialCategory2Name;
            private int rawMaterialId;
            private String rawMaterialName;
            private int sampleId;

            public int getFactoryId() {
                return factoryId;
            }

            public void setFactoryId(int factoryId) {
                this.factoryId = factoryId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Double getQuantity() {
                return quantity;
            }

            public void setQuantity(Double quantity) {
                this.quantity = quantity;
            }

            public int getRawMaterialCategory1Id() {
                return rawMaterialCategory1Id;
            }

            public void setRawMaterialCategory1Id(int rawMaterialCategory1Id) {
                this.rawMaterialCategory1Id = rawMaterialCategory1Id;
            }

            public String getRawMaterialCategory1Name() {
                return rawMaterialCategory1Name;
            }

            public void setRawMaterialCategory1Name(String rawMaterialCategory1Name) {
                this.rawMaterialCategory1Name = rawMaterialCategory1Name;
            }

            public int getRawMaterialCategory2Id() {
                return rawMaterialCategory2Id;
            }

            public void setRawMaterialCategory2Id(int rawMaterialCategory2Id) {
                this.rawMaterialCategory2Id = rawMaterialCategory2Id;
            }

            public String getRawMaterialCategory2Name() {
                return rawMaterialCategory2Name;
            }

            public void setRawMaterialCategory2Name(String rawMaterialCategory2Name) {
                this.rawMaterialCategory2Name = rawMaterialCategory2Name;
            }

            public int getRawMaterialId() {
                return rawMaterialId;
            }

            public void setRawMaterialId(int rawMaterialId) {
                this.rawMaterialId = rawMaterialId;
            }

            public String getRawMaterialName() {
                return rawMaterialName;
            }

            public void setRawMaterialName(String rawMaterialName) {
                this.rawMaterialName = rawMaterialName;
            }

            public int getSampleId() {
                return sampleId;
            }

            public void setSampleId(int sampleId) {
                this.sampleId = sampleId;
            }
        }

        public static class ProductProcessListBean {
            /**
             * factoryId : 0
             * id : 0
             * isOutsourcing : 0
             * price : 0
             * processId : 0
             * processName : string
             * sampleId : 0
             * sequence : 0
             * stageId : 0
             * stageName : string
             */

            private int factoryId;
            private int id;
            private int isOutsourcing;
            private Double price;
            private int processId;
            private String processName;
            private int sampleId;
            private int sequence;
            private int stageId;
            private String stageName;

            public int getFactoryId() {
                return factoryId;
            }

            public void setFactoryId(int factoryId) {
                this.factoryId = factoryId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsOutsourcing() {
                return isOutsourcing;
            }

            public void setIsOutsourcing(int isOutsourcing) {
                this.isOutsourcing = isOutsourcing;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            public int getProcessId() {
                return processId;
            }

            public void setProcessId(int processId) {
                this.processId = processId;
            }

            public String getProcessName() {
                return processName;
            }

            public void setProcessName(String processName) {
                this.processName = processName;
            }

            public int getSampleId() {
                return sampleId;
            }

            public void setSampleId(int sampleId) {
                this.sampleId = sampleId;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public int getStageId() {
                return stageId;
            }

            public void setStageId(int stageId) {
                this.stageId = stageId;
            }

            public String getStageName() {
                return stageName;
            }

            public void setStageName(String stageName) {
                this.stageName = stageName;
            }
        }

        public static class SizeListBean {
            /**
             * factoryId : 0
             * id : 0
             * sampleId : 0
             * sampleSizeInformationList : [{"factoryId":0,"id":0,"quantity":0,"sampleId":0,"sampleSizeId":0,"sizeId":0,"sizeInfomationId":0,"sizeInformationName":"string"}]
             * sizeGroupId : 0
             * sizeGroupName : string
             * sizeId : 0
             * sizeName : string
             */

            private int factoryId;
            private int id;
            private int sampleId;
            private int sizeGroupId;
            private String sizeGroupName;
            private int sizeId;
            private String sizeName;
            private List<SampleSizeInformationListBean> sampleSizeInformationList;

            public int getFactoryId() {
                return factoryId;
            }

            public void setFactoryId(int factoryId) {
                this.factoryId = factoryId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSampleId() {
                return sampleId;
            }

            public void setSampleId(int sampleId) {
                this.sampleId = sampleId;
            }

            public int getSizeGroupId() {
                return sizeGroupId;
            }

            public void setSizeGroupId(int sizeGroupId) {
                this.sizeGroupId = sizeGroupId;
            }

            public String getSizeGroupName() {
                return sizeGroupName;
            }

            public void setSizeGroupName(String sizeGroupName) {
                this.sizeGroupName = sizeGroupName;
            }

            public int getSizeId() {
                return sizeId;
            }

            public void setSizeId(int sizeId) {
                this.sizeId = sizeId;
            }

            public String getSizeName() {
                return sizeName;
            }

            public void setSizeName(String sizeName) {
                this.sizeName = sizeName;
            }

            public List<SampleSizeInformationListBean> getSampleSizeInformationList() {
                return sampleSizeInformationList;
            }

            public void setSampleSizeInformationList(List<SampleSizeInformationListBean> sampleSizeInformationList) {
                this.sampleSizeInformationList = sampleSizeInformationList;
            }

            public static class SampleSizeInformationListBean {
                /**
                 * factoryId : 0
                 * id : 0
                 * quantity : 0
                 * sampleId : 0
                 * sampleSizeId : 0
                 * sizeId : 0
                 * sizeInfomationId : 0
                 * sizeInformationName : string
                 */

                private int factoryId;
                private int id;
                private int quantity;
                private int sampleId;
                private int sampleSizeId;
                private int sizeId;
                private int sizeInfomationId;
                private String sizeInformationName;

                public int getFactoryId() {
                    return factoryId;
                }

                public void setFactoryId(int factoryId) {
                    this.factoryId = factoryId;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getQuantity() {
                    return quantity;
                }

                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }

                public int getSampleId() {
                    return sampleId;
                }

                public void setSampleId(int sampleId) {
                    this.sampleId = sampleId;
                }

                public int getSampleSizeId() {
                    return sampleSizeId;
                }

                public void setSampleSizeId(int sampleSizeId) {
                    this.sampleSizeId = sampleSizeId;
                }

                public int getSizeId() {
                    return sizeId;
                }

                public void setSizeId(int sizeId) {
                    this.sizeId = sizeId;
                }

                public int getSizeInfomationId() {
                    return sizeInfomationId;
                }

                public void setSizeInfomationId(int sizeInfomationId) {
                    this.sizeInfomationId = sizeInfomationId;
                }

                public String getSizeInformationName() {
                    return sizeInformationName;
                }

                public void setSizeInformationName(String sizeInformationName) {
                    this.sizeInformationName = sizeInformationName;
                }
            }
        }

        public static class WashingProcessListBean {
            /**
             * factoryId : 0
             * id : 0
             * sampleId : 0
             * washingProcessId : 0
             * washingProcessName : string
             */

            private int factoryId;
            private int id;
            private int sampleId;
            private int washingProcessId;
            private String washingProcessName;

            public int getFactoryId() {
                return factoryId;
            }

            public void setFactoryId(int factoryId) {
                this.factoryId = factoryId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSampleId() {
                return sampleId;
            }

            public void setSampleId(int sampleId) {
                this.sampleId = sampleId;
            }

            public int getWashingProcessId() {
                return washingProcessId;
            }

            public void setWashingProcessId(int washingProcessId) {
                this.washingProcessId = washingProcessId;
            }

            public String getWashingProcessName() {
                return washingProcessName;
            }

            public void setWashingProcessName(String washingProcessName) {
                this.washingProcessName = washingProcessName;
            }
        }
    }

    public static class InventorySampleLogListBean {
        /**
         * employeeRecordId : 0
         * employeeRecordName : string
         * factoryId : 0
         * gmtCreate : 2019-06-17T09:35:23.119Z
         * id : 0
         * item : 0
         * noteId : 0
         * productionOrderId : 0
         * quantity : 0
         * remainingQuantity : 0
         * remarks : string
         * sampleId : 0
         * title : string
         * type : 0
         */

        private int employeeRecordId;
        private String employeeRecordName;
        private int factoryId;
        private String gmtCreate;
        private int id;
        private int item;
        private Integer noteId;

        public Integer getNoteId() {
            return noteId;
        }

        public void setNoteId(Integer noteId) {
            this.noteId = noteId;
        }

        private int productionOrderId;
        private int quantity;
        private int remainingQuantity;
        private String remarks;
        private int sampleId;
        private String title;
        private int type;

        public int getEmployeeRecordId() {
            return employeeRecordId;
        }

        public void setEmployeeRecordId(int employeeRecordId) {
            this.employeeRecordId = employeeRecordId;
        }

        public String getEmployeeRecordName() {
            return employeeRecordName;
        }

        public void setEmployeeRecordName(String employeeRecordName) {
            this.employeeRecordName = employeeRecordName;
        }

        public int getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(int factoryId) {
            this.factoryId = factoryId;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }



        public int getProductionOrderId() {
            return productionOrderId;
        }

        public void setProductionOrderId(int productionOrderId) {
            this.productionOrderId = productionOrderId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getRemainingQuantity() {
            return remainingQuantity;
        }

        public void setRemainingQuantity(int remainingQuantity) {
            this.remainingQuantity = remainingQuantity;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public int getSampleId() {
            return sampleId;
        }

        public void setSampleId(int sampleId) {
            this.sampleId = sampleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class OrdersListBean {
        /**
         * clientRecordId : 0
         * createBy : 0
         * factoryId : 0
         * finishBy : 0
         * gmtCreate : 2019-06-17T09:35:23.119Z
         * gmtFinish : 2019-06-17T09:35:23.119Z
         * gmtModified : 2019-06-17T09:35:23.119Z
         * gmtStop : 2019-06-17T09:35:23.119Z
         * id : 0
         * orderNumber : string
         * orderSampleId : 0
         * quantity : 0
         * remarks : string
         * sampleId : 0
         * shippingAddress : string
         * status : 0
         * stopBy : 0
         * unitPrice : 0
         */

        private int clientRecordId;
        private int createBy;
        private int factoryId;
        private int finishBy;
        private String gmtCreate;
        private String gmtFinish;
        private String gmtModified;
        private String gmtStop;
        private int id;
        private String orderNumber;
        private int orderSampleId;
        private int quantity;
        private String remarks;
        private int sampleId;
        private String shippingAddress;
        private int status;
        private int stopBy;
        private Double unitPrice;

        public int getClientRecordId() {
            return clientRecordId;
        }

        public void setClientRecordId(int clientRecordId) {
            this.clientRecordId = clientRecordId;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public int getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(int factoryId) {
            this.factoryId = factoryId;
        }

        public int getFinishBy() {
            return finishBy;
        }

        public void setFinishBy(int finishBy) {
            this.finishBy = finishBy;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtFinish() {
            return gmtFinish;
        }

        public void setGmtFinish(String gmtFinish) {
            this.gmtFinish = gmtFinish;
        }

        public String getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(String gmtModified) {
            this.gmtModified = gmtModified;
        }

        public String getGmtStop() {
            return gmtStop;
        }

        public void setGmtStop(String gmtStop) {
            this.gmtStop = gmtStop;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public int getOrderSampleId() {
            return orderSampleId;
        }

        public void setOrderSampleId(int orderSampleId) {
            this.orderSampleId = orderSampleId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public int getSampleId() {
            return sampleId;
        }

        public void setSampleId(int sampleId) {
            this.sampleId = sampleId;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStopBy() {
            return stopBy;
        }

        public void setStopBy(int stopBy) {
            this.stopBy = stopBy;
        }

        public Double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
        }
    }
}
