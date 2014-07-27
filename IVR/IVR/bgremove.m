	x=imread(['00000002.jpg'],'jpg');
	%x=normalizeRGB(im2double(x));
	partim = im2uint8(rgb2gray(x));
	imshow(x);
	
	bgim = im2uint8(rgb2gray(background));
	 imshow(partim); 
  %figure(4)
  %colormap(gray)
  %imshow(partim);

  [H,W] = size(partim);
  outim = zeros(H,W);
  for r = 1 : H
  for c = 1 : W
    outim(r,c) = double(partim(r,c))/double(bgim(r,c));
  end
  end

  % set up bin edges for histogram
  edges = zeros(256,1);
  for i = 1 : 256;
          edges(i) = i-1;
  end
            
  %figure(1)
  imagevec = reshape(partim,1,H*W);      % turn image into long array
  myhist = histc(imagevec,edges);        % do histogram
  %plot(myhist);
  %axis([0, 255, 0, 1.1*max(myhist)]);

  %figure(2)
  newedges = zeros(256,1);
  for i = 1 : 256;
          newedges(i) = (i-1)/100;
  end
  oimagevec = (reshape(outim,1,H*W));      % turn image into long array
  omyhist = histc(oimagevec,newedges)';        % do histogram
  %plot(omyhist);
  %axis([0, max(100*oimagevec), 0, 1.1*max(omyhist)]);

%  ind = find(myhist==max(myhist))
  

  %figure(3)
  %colormap(gray)
	ss=im2double(partim);
	imshow(partim);
	thr=graythresh(ss);
	thr2=graythresh(bgim);
  binimage = ~im2bw(outim/max(max(outim)),0.4);       % do thresholding
	%binimage = imerode(binimage,strel('disk',2));	
  imshow(binimage);
  
