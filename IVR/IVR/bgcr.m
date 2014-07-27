%function bg = bgcr(foldr)
foldr = 'fol1';
D = dir(fullfile(foldr,'*.jpg'));
imcell = cell(1,numel(D));
for i = 1:numel(D)
  imcell{i} = im2double(imread(strcat(foldr,'/',D(i).name)));
end
inimage=imcell{2};
for i=1 : 100
	images(:,:,:,i)=imcell{i}(:,:,:);
end
%images= imcell;

 %for i=1:100
            
   %         images'%d'(:,:,:) = imcell{i};
            
% end


%subimages = imcell{1:10:end}(:, :, :);

subimages = images(:, :, :, 40:2:end);
background = median(subimages, 4);
imshow(background, []);




%background = zeros(480,640,3);

% for j=1:480
%    for i=1:640
%        tmpR = zeros(1,10);
%        tmpG = zeros(1,10);
%        tmpB = zeros(1,10);
%        for k=1:10
%		tmpR(k)=imcell{k*10}(j,i,1);
%		%imshow(tmpR(k));
%		tmpG(k)=imcell{k*10}(j,i,2);
%		tmpB(k)=imcell{k*10}(j,i,3);
 %           %tmpR(k) = tmpR(j,i,1);
  %          %tmpG(k) = images(j,i,2,k*10);
   %         %tmpB(k) = images(j,i,3,k*10);
%
 %       end
  %      background(j,i,1) = floor(median(tmpR));
   %     background(j,i,2) = floor(median(tmpG));
    %    background(j,i,3) = floor(median(tmpB));
    %end
%end
