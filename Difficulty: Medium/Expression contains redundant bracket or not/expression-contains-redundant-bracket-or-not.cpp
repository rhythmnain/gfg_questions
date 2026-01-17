class Solution {
  public:
    bool checkRedundancy(string &s) {
        // code here
        int n = s.size();
        for(int i = 0; i + 2 < n; i++)
        {
            if(s[i] == '(' && s[i + 2] == ')')return true;
        }
        stack<char>st;
        for(auto &ch : s)
        {
            // cout<<ch<<endl;
            if(ch == '(')
            {
                // cout<<1<<endl;
                st.push(ch);
            }
            else if(ch == ')')
            {
                // cout<<2<<endl;
                st.push(')');
            }
            else
            {
                // cout<<3<<endl;
                if(st.size() && st.top() != 'a')
                {
                    // cout<<4<<endl;
                    st.push('a');
                }
            }
            
        }
        s = "";
        while(st.size())
        {
            s = st.top() + s; st.pop();
        }
        // cout<<s<<endl;
        n = s.size();
        for(int i = 0; i + 4 < n; i++)
        {
            if(s[i] == '(' && s[i + 1] == '(' && s[i + 3] == ')' && s[i + 4] == ')')
            return true;
        }
        
        int burst = 0;
        for(auto &ch : s)
        {
            if(ch == ')')
            {
                while(st.top()!= '(')
                {
                    burst = 0;
                    st.pop();
                }
                st.pop();
                if(burst == 1)return true;
                burst++;
            }
            else if(ch == '(')
            {
                burst = 0;
                st.push('(');
            }
            else
            {
                st.push('a');
                burst = 0;
                
            }
        }
        return false;
    }
};
