//邻接矩阵的遍历
typedef struct{
	int amount;
	int *vex;
	int **matrix;
}Graph;

//打印从i到j的所有回路
void PrintAllPath(Graph& G, int i, int j){
	if( i > G.amount || j > G.amount || i < 0 || j < 0)
		return;

	//初始化访问标识
	bool *IsVisted = (bool *)malloc(sizeof(bool) * G.amount);
	for(int k = 0; k < G.amount; k++)
		IsVisted[k] = false;

	std::stack<int> s_Gnode;
	s_Gnode.push(G.vex[i]);
	IsVisted[i] = true;

	//程序的关键是设置了pop_node和top_node; 
	//因为图是按照序号的从小到大访问，所以一旦有pop_node,必须从pop_node+1开始访问
	int top_node;
	int pop_node = -1;//最开始pop_node从0开始遍历

	while( !s_Gnode.empty()){
		top_node = s_Gnode.top();
		int k;
		for( k = pop_node+1; k < G.amount; k++ ){
			if(G.matrix[top_node][k] == 1 && IsVisted[k] == false){
				//如果当前节点是j节点，则打印栈中的所有元素
				if(G.vex[k] == j){
					s_Gnode.push(G.vex[k]);
					PrintStack(s_Gnode);
					pop_node = s_Gnode.top();
					s_Gnode.pop();
					break;
				}
				else{
					pop_node = -1; //注意每次pop之后有新的节点进栈，需要将pop_node归零
					IsVisted[k] = true;
					s_Gnode.push(G.vex[k]);
					break;
				}
			}
		}//for

		//如果所有邻接的节点都被访问了
		if(k == G.amount){
			pop_node = s_Gnode.top();
			//将之前的所有邻接节点置为未访问
			for( int c = 0; c < G.amount; c++)
				//注意避免出现访问环，需要判断邻接点是否包含起始节点
				if(G.matrix[pop_node][c] == 1 && (c != i) )
					IsVisted[c] = false;
			s_Gnode.pop();
		}
	}
}

void PrintStack(std::stack<int> s_Gnode){
	while( !s_Gnode.empty() ){
		printf("%d\t", s_Gnode.top());
		s_Gnode.pop();
	}
	printf("\n");
}

