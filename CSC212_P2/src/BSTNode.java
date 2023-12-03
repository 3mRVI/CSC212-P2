   // CLASS: PhaseTwo.java

// CSC212 Data structures - Project phase II

// Fall 2023

// EDIT DATE:

// 

// TEAM:

// O.Y.A

// AUTHORS:

// Yazeed Aljarwan(443105683) Omar Alotabi (443101535) Abdullah Aldawood, (443105732) 

// ***/
   class BSTNode  {  
                public String key;    
                public Contact data;  
                public BSTNode left, right;  
      
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
        }  
  
