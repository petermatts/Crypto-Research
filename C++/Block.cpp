#include <iostream>
// #include <string>
using namespace std;

class Block {
    private:
        string hash;

    public:
        Block(string hash);
        void printHash() { cout << hash << endl; }
        string getHash() { return hash; }
};

Block::Block(string h) {
    hash = h;
}

int main() {
    Block b("abcd");
    b.printHash();
    cout << b.getHash();
}
