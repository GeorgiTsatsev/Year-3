function outimage = findthresh(A)
	%B=normalize(im2double(A));	
	A=smoothing(A);
	imshow(A);
	A=getBlue(A);
	%imshow(A);
	
	
	%B=smoothing(B);
		
	%B=getBlue(B);
	
	[m,n]=size(A);	
	hist=imhist(A);
	%hist=hist/(m*n);
	%B=im2uint8(A);	
	%B=A;	
	%x=maxentropie(B)
	%hist2=imhist(B);
%	plot(hist2);
	%plot(hist);
	outimage = zeros(m,n);
	thresh=findthresh2(hist,4,0);
	%thresh2=findthresh2(hist2,4,0);
	thresh=thresh	
	%thresh2=thresh2
	thresh =thresh/(256*2)
	%imshow(A);
	%A=im2uint8(A);
	%imshow(A);
	for i = 1 : m
		for j = 1 : n
			if A(i,j) >= thresh % & A(i,j) < thresh+thresh2
			%if A(i,j) < 1 & A(i,j) >0 % & A(i,j) < thresh+thresh2
				%temp=A(i,j)
						
				outimage(i,j) = 1;
			else
				outimage(i,j) = 0;
			end
		end
	end


	%imshow(outimage);
