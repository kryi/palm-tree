#include <iostream>
using namespace std;
class Vector
{
    public:
    Vector(int =1);
    Vector(const int *,int );
    Vector(const Vector &);
    ~Vector();
    int &operator[](int i)const;
    int operator()()const;
    Vector &operator=(const Vector &);
    bool operator==(const Vector&)const;
    bool operator!=(const Vector &)const;
    friend Vector operator+(const Vector&,const Vector&);
    friend ostream &operator<<(ostream&output,const Vector&);
    friend istream &operator<<(istream&input,Vector&);
    int *v;
    int len;
};
Vector::Vector(int size)
{
    v=new int[size];
    for(int i=0;i<size;i++)
     v[i]=0;
     len=size;
};
Vector::Vector(const int *B,int size)
{

    v=new int[size];
    len=size;
    for(int i=0;i<size;i++)
     v[i]=B[i];
}
Vector::Vector(const Vector &A)
{
    len=A();
    v=new int[len];
    for(int i=0;i<len;i++)
     v[i]=A[i];
}
Vector::~Vector()
{
    delete[]v;
    len=0;
}
int &Vector::operator[](int i)const
{
    if(i>=0||i<len)
    {
        return v[i] ;
    }
}
int Vector::operator()()const
{
    return len;
}
Vector &Vector::operator=(const Vector&B)
{
    if(len==B())
    {
        for(int i=0;i<len;i++)
         v[i]=B[i];
         return *this;
    }
}
bool Vector::operator==(const Vector&B) const
{
    if(len==B.len)
    {
        for(int i=0;i<len;i++)
         if(v[i]!=B.v[i]) return false;
    }
    else return false;
    return true;
}
bool Vector::operator!=(const Vector&B) const
{
    return !(*this==B);
}
Vector operator+(const Vector &A,const Vector&B)
{
    int size=A();
    int *T=new int [size];
    if(size==B())
    {
        for(int i=0;i<size;i++)
         T[i]=A.v[i]+B.v[i];
         return Vector(T,size);
    }
}
ostream &operator<<(ostream &output,const Vector&A)
{
    for(int i=0;i<A.len;i++)
     output<<A.v[i]<<" ";
     return output;
}
istream &operator>>(istream &input,const Vector&A)
{
    for(int i=0;i<A.len;i++)
     input>>A.v[i];
     return input;
}
int main()
{
    int k;
    cin>>k;
    Vector A(k),B(k),C(k);
    cin>>A;
    cin>>B;
    C=A+B;
    cout<<A<<endl;
    cout<<B<<endl;
    cout<<C<<endl;
    cin>>C;
    return 0;
}
