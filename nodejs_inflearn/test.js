const candyMachine = {
    status: {
        name: 'node',
        count: 5,
    },
    getCandy() {
        this.status.count--;
        return this.status.count;
    },
};

const { status: { count }} = candyMachine;

console.log(count)

console.log(candyMachine.getCandy())