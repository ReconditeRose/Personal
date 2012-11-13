/*
 * distributions.c
 *
 *  Created on: Jun 30, 2012
 *      Author: olsonmc
 */


long itemsInBins(int bins, int items){
//	int sum = 0;
//	int i;
//	if(bins==1||items==0){
//		return 1;
//	}
//	for(int i =0;i<=items;i++){
//		sum+= itemsInBins(bins-1,items-i);
//	}
//	return sum;
	items = items +1;
	int i;
	long hold [bins-1][items];
	for(int n=0;n<(bins-1);n++){
		for(int m=0;m<items;m++){
			hold[n][m]=0;
		}
	}
	for(i =0;i<items;i++){
		hold[bins-2][i]=1;
	}
	for(int j = bins-3;j>=0;j--){
		for(int k = 0;k < items ; k++){
			for(i=k;i<items;i++){
				hold[j][k]+=hold[j+1][i];
			}
		}
	}
	long long sum = 0;
	for(i=0;i<items;i++){
		sum+=hold[0][i];
	}
	return sum;

}

long numberIntoBins(int number){
	return 0;
}

//long objectsIntoBins(int number,int * objects){
//	return 0;
//}
