   class BSTNode  {  
                public String key;    
                public Contact data;  
                public BSTNode left, right;  
      
                /** Creates a new instance of BTNode */  
                public BSTNode() {  
                        left = right = null;  
                }  
      
                public BSTNode(String key, Contact data) {  
                        this.key = key  ;    
                        this.data = data;  
                        left = right = null;  
                }  
      
                public BSTNode(String key, Contact data, BSTNode l, BSTNode r){  
                        this.key = key  ;    
                        this.data = data;  
                        left = l;  
                        right = r;  
                }  
                  
            @Override  
            public String toString() {  
                return " ["+ "key=" + key + ", data=" + data + "] ";  
            }  
      
 
        }  
        //================================================================================  
  
