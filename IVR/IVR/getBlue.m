function getBlue = getBlue(A)
	[m,n,k]=size(A);
	R = A(:,:,1);
	G = A(:,:,2);
	B = A(:,:,3);


	getBlue = G;

