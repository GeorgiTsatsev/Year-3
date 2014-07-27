function getRed = getRed(A)
	[m n k] = size(A);
	hsv = rgb2hsv(A);
	H = hsv(:,:,1);
	S = hsv(:,:,2);
	V = hsv(:,:,3);


	for i=1:m
		for j=1:n
			

			if S(i,j)<=0.6 | H(i,j)>=0.1 
				S(i,j)=0;
			else
				S(i,j)=1;
			end
		end
	end
	fshsv = cat(3,H,S,V);
	getRed = hsv2rgb(fshsv);	
	

