#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;
class book
{
    private:
    string author,name;
    int money,number;
    public:
    void setbook(string s1,string s2,int a,int b)
    {
        author=s1;
        name=s2;
        money=a;
        number=b;
    }
    void print()
    {

        ofstream fout;
        fout.open("g://book.txt",ios::app);
        fout<<author<<" "<<name<<" "<<money<<" "<<number<<endl;
        cout<<author<<" "<<name<<" "<<money<<" "<<number<<endl;
        fout.close();
    }
    int getSumMoney()const;
    int getNum()const;
};
int book::getSumMoney()const
{
    return money*number;
}
int book::getNum()const
{
    return number;
}
int main()
{
    ifstream fin;ofstream fout;
   //ofstream fout;
    fin.open("d:\\file.txt");
    fout.open("g:\\book.txt");
    string a,n,s1,s2;
    int m,t;
    fin>>s1;
    cout<<s1<<endl;
    fin>>a>>n>>s1>>s2;
    cout<<a<<" "<<n<<" "<<s1<<" "<<s2<<endl;
    int ans=0,d=0,len=0;
    //book *p;
    book b[10];
    while(fin>>a>>n>>m>>t)
    {

        b[len].setbook(a,n,m,t);
        b[len].print();
        len++;
    }
    for(int i=0;i<len;i++)
    {
        ans+=b[i].getSumMoney();
        d+=b[i].getNum();

    }
    cout<<ans<<" "<<d<<endl;
    fin.close();
    fout.close();
    return 0;
}
