    import java.util.Date;  
      
    public class BST<K extends Comparable<K>,T> {  
        //================================================================================  
        BSTNode root, current;  
      
        /** Creates a new instance of BST */  
        public BST() {  
                root = current = null;  
        }  
      
        public boolean empty() {  
                return root == null;  
        }  
      
        public boolean full() {  
                return false;  
        }  
      
        public Contact retrieve () {  
                return current.data;  
        }  
      
        public boolean findkey(String tkey) {  
                BSTNode  p = root, q = root;  
      
                if(empty())  
                        return false;  
      
                while(p != null) {  
                        q = p;  
                        if(p.key.compareTo(tkey) == 0) {  
                                current = p;  
                                return true;  
                        }  
                        else if(tkey.compareTo(p.key) < 0)  
                                p = p.left;  
                        else  
                                p = p.right;  
                }  
                current = q;  
                return false;  
        }  
        public boolean addSort(String name, Contact val) {  
                BSTNode  p, q = current;  
      
                if(findkey(name)) {  
                        current = q;  // findkey() modified current  
                        return false; // key already in the BST  
                }  
      
                p = new BSTNode (name, val);  
                if (empty()) {  
                        root = current = p;  
                        return true;  
                }  
                else {  
                        // current is pointing to parent of the new key  
                        if (name.compareTo(current.key) < 0)  
                                current.left = p;  
                        else  
                                current.right = p;  
                        current = p;  
                        return true;  
                }  
        }  
      
        public boolean remove_key (String tkey){  
                Boolean removed = new Boolean(false);  
                BSTNode  p;  
                p = remove_aux(tkey, root, removed);  
                current = root = p;  
                return removed;  
        }  
          
        private BSTNode  remove_aux(String key, BSTNode  p, Boolean flag) {  
                BSTNode  q, child = null;  
                if(p == null)  
                        return null;  
                if(key.compareTo(p.key) <0)  
                        p.left = remove_aux(key, p.left, flag); //go left  
                else if(key.compareTo(p.key) >0)  
                        p.right = remove_aux(key, p.right, flag); //go right  
                else {  
                        flag = true;  
                        if (p.left != null && p.right != null){ //two children  
                                q = find_min(p.right);  
                                p.key = q.key;  
                                p.data = q.data;  
                                p.right = remove_aux(q.key, p.right, flag);  
                        }  
                else {  
                                if (p.right == null) //one child  
                                        child = p.left;  
                                else if (p.left == null) //one child  
                                        child = p.right;  
                                return child;  
                        }  
                }  
                return p;  
        }  
      
        private BSTNode  find_min(BSTNode  p)  
        {  
                if(p == null)  
                        return null;  
      
                while(p.left != null){  
                        p = p.left;  
                }  
      
                return p;  
        }  
          
        public boolean update(String key, Contact data)  
        {  
                String key1 = key;   
                remove_key(key1);  
                 return addSort(key1, data);  
        }  
      
        //Method removeKey: iterative    
        public boolean removeKey(String k) {  
        // Search   
        String k1 = k;        
        BSTNode p = root;        
        BSTNode  q = null;    // Parent of p  
          
        while (p != null)   
        {  
            if (k1.compareTo(p.key) <0)   
            {  
                q =p;  
                p = p.left;  
            }  
            else if (k1.compareTo(p.key) >0)   
            {  
                q = p;  
                p = p.right;  
            }   
            else {   
                // Found the key              
                // Check the three cases  
                if ((p.left != null) && (p.right != null))   
                {   
        // Case 3: two children                  
                        // Search for the min in the right subtree  
                        BSTNode min = p.right;  
                        q = p;  
                        while (min.left != null)   
                        {  
                            q = min;  
                            min = min.left;  
                        }  
                        p.key = min.key;                 
                        p.data = min.data;  
                        k1 = min.key;  
                        p = min;  
                        // Now fall back to either case 1 or 2  
                }  
                // The subtree rooted at p will change here               
                if (p.left != null)   
                {   
                    // One child  
                    p = p.left;  
                }   
                else   
                {   
                    // One or no children  
                    p = p.right;  
                }  
                  
                if (q == null)   
                {   
                    // No parent for p, root must change  
                    root = p;  
                }   
                else   
                {  
                    if (k1.compareTo(q.key) <0)   
                    {  
                        q.left = p;  
                    }   
                    else   
                    {  
                        q.right = p;  
                    }  
                }  
                current = root;  
                return true;  
            }  
        }  
        return false; // Not found  
        }  
     
      
       
        public boolean SearchPhone(String phone)  
        {  
            return SearchPhone_rec (root, phone);  
        }  
        private boolean SearchPhone_rec (BSTNode  p, String phone)  
        {  
            if (p == null)  
                return false;  
            else    if ((p.data).compareToPhone(phone) == 0)  
            {  
                current = p;  
                return true;  
            }  
              
            return (SearchPhone_rec(p.left , phone) || SearchPhone_rec(p.right, phone));  
        }//O(n)
      
       
        public void SearchEmail(String email)  
        {  
            SearchEmail_rec (root, email);  
        }  
        private void SearchEmail_rec (BSTNode p, String email)  
        {  
            if (p == null)  
                return;  
              
            else    if (((Contact)p.data).compareToEmail(email) == 0)  
                System.out.println(p.data);  
              
            SearchEmail_rec(p.left , email);  
            SearchEmail_rec(p.right, email);  
        }  
          //o(n)
        
        public void SearchAddress(String address)  
        {  
            SearchAddress_rec (root, address);  
        }  
        private void SearchAddress_rec (BSTNode  p, String address)  
        {  
            if (p == null)  
                return ;  
            else    if (((Contact)p.data).compareToAddress(address) == 0)  
                System.out.println(p.data);  
              
            SearchAddress_rec(p.left , address);  
            SearchAddress_rec(p.right, address);  
        } //O(n) 
          
       
        public void SearchBirthday(Date birthday)  
        {  
            SearchBirthday_rec (root, birthday);  
        }  
        private void SearchBirthday_rec (BSTNode  p, Date birthday)  
        {  
            if (p == null)  
                return ;  
            else    if (((Contact)p.data).compareToBirthday(birthday) == 0)  
                System.out.println(p.data);  
              
            SearchBirthday_rec(p.left , birthday);  
            SearchBirthday_rec(p.right, birthday);  
        } //O(n)
       
        public void SearchSameFirstName(String name)  
        {  
            SearchSameFirstName_rec (root, name.trim());  
        }  
        private void SearchSameFirstName_rec (BSTNode p, String name)  
        {  
            if (p == null)  
                return ;  
            else    if ((p.data).compareFirstName(name) == 0)  
                System.out.println(p.data);  
             
            SearchSameFirstName_rec(p.left , name);  
            SearchSameFirstName_rec(p.right, name);  
        }  //O(n)
      
    }  