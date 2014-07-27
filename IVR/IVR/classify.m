% classifies a test feature vector v into one of N classes
% given the class means (Means) and inverse of covariance matrices
% (Invcors) and aprori probabilities (Aprioris)
function class = classify(v,N,Means,Invcors,Dim,Aprioris)

        evals = zeros(N,1);
        IC = zeros(Dim,Dim);
        for i = 1 : N
            % We need to reshape since Invcors(i,:,:) gives 1xDimxDim matrix
            IC = reshape(Invcors(i,:,:),Dim,Dim);
            evals(i) = multivariate(v,Means(i,:),IC,Aprioris(i));
        end
        evaluations = evals'
        bestclasses = find(evals == max(evals));
        class = bestclasses(1);
