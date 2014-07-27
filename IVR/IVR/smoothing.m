function smoothing = smoothing(S)
	%imshow(S);	
	[m n k] = size(S);
	% S=normalize(im2double(S));
	%imshow(S);
	for ii = 1:3
    	%	S(:,:,ii) = medfilt2(S(:,:,ii),[6 6]);
	end
	
	%imshow(S);
	S= im2uint8(S);
	hsv = rgb2hsv(S);
	%hsv=normalizeRGB(hsv);
	%imshow(f);
	H = hsv(:,:,1);
	S = hsv(:,:,2);
	V = hsv(:,:,3);
	

	for i=1:m
		for j=1:n
			

			%if S(i,j)<=0.29 | (H(i,j)>20/360 & H(i,j)<340/360)
			%if (S(i,j)<=0.2 | S(i,j)>=0.5)|(V(i,j)<0.2 | V(i,j)>0.3)
			%if S(i,j)<=0.5
			if S(i,j)<=0.29 
				V(i,j)=0;			
			else 
				%S(i,j)=1;
				%V(i,j)=0;
				
				
			end
		end
	end
	
	fshsv = cat(3,H,S,V);
	smoothing = hsv2rgb(fshsv);	
	%smoothing = imopen(smoothing,strel('disk',19));
	smoothing = imerode(smoothing,strel('disk',1));	



